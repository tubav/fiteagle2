package org.fiteagle.dm.ws;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fiteagle.dm.ws.ConfigurationWebSocket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationWebSocketTest {

	private static final String TOPIC = "topic";
	private static final String EXPECTED = "123";

	private ConnectionFactory factory = new ActiveMQConnectionFactory(
			"vm://localhost?broker.persistent=false");
	private Connection connection;

	@Before
	public void setup() throws JMSException {
		this.connection = factory.createConnection();
		Session mockSession = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Topic destination = mockSession.createTopic(TOPIC);
		MessageConsumer consumer = mockSession.createConsumer(destination);
		consumer.setMessageListener(new MockListener(mockSession));
		connection.start();
	}

	@Test
	public void testGetVersionCall() throws JMSException {
		Session session = this.connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Topic destination = session.createTopic(TOPIC);
		MessageProducer producer = session.createProducer(destination);

		ConfigurationWebSocket v = new ConfigurationWebSocket(session, producer);

		Assert.assertEquals(EXPECTED, v.onMessage("getVersion"));
	}

	private class MockListener implements MessageListener {
		private Session session;

		public MockListener(Session session) {
			this.session = session;
		}

		@Override
		public void onMessage(Message textMessage) {
			try {
				TextMessage result = session.createTextMessage(EXPECTED);
				result.setJMSCorrelationID(textMessage.getJMSCorrelationID());
				Destination replyTo = textMessage.getJMSReplyTo();
				session.createProducer(null).send(replyTo, result);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}