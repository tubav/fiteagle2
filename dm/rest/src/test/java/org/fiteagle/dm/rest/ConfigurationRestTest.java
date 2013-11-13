package org.fiteagle.dm.rest;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationRestTest {

	private static final String EXPECTED = "123";

	private MessageBus mockmessagebus;

	@Before
	public void setup() throws JMSException {
		this.mockmessagebus = new MessageBusLocal();
		MessageConsumer consumer = mockmessagebus.getConsumer();
		consumer.setMessageListener(new MockListener(this.mockmessagebus
				.getSession()));
	}

	@Test
	public void testGetVersionCall() throws JMSException {
		MessageBus messagebus = new MessageBusLocal();
		ConfigurationRest v = new ConfigurationRest(messagebus.getSession(),
				messagebus.getProducer());

		Assert.assertEquals(EXPECTED, v.getValue("getVersion"));
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