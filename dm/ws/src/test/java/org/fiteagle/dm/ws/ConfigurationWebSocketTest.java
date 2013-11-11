package org.fiteagle.dm.ws;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fiteagle.boundary.MessageBus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationWebSocketTest {

	private static final String EXPECTED = "123";

	private ConnectionFactory factory = new ActiveMQConnectionFactory(
			"vm://localhost?broker.persistent=false");
	private MessageBus mockmessagebus;
	

	@Before
	public void setup() throws JMSException {
		this.mockmessagebus = new MessageBus(this.factory);
		MessageConsumer consumer = mockmessagebus.getConsumer();
		consumer.setMessageListener(new MockListener(this.mockmessagebus.getSession()));
	}

	@Test
	public void testGetVersionCall() throws JMSException {
		MessageBus messagebus = new MessageBus(this.factory);
		MessageProducer producer = messagebus.getProducer();

		ConfigurationWebSocket v = new ConfigurationWebSocket(messagebus.getSession(), producer);

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