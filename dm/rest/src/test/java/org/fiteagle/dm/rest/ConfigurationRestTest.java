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

	private class MockListener implements MessageListener {
		private final Session session;

		public MockListener(final Session session) {
			this.session = session;
		}

		@Override
		public void onMessage(final Message textMessage) {
			try {
				final TextMessage result = this.session
						.createTextMessage(ConfigurationRestTest.EXPECTED);
				result.setJMSCorrelationID(textMessage.getJMSCorrelationID());
				final Destination replyTo = textMessage.getJMSReplyTo();
				this.session.createProducer(null).send(replyTo, result);
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}

	private static final String EXPECTED = "123";

	private MessageBus mockmessagebus;

	@Before
	public void setup() throws JMSException {
		this.mockmessagebus = new MessageBusLocal();
		final MessageConsumer consumer = this.mockmessagebus.getConsumer();
		consumer.setMessageListener(new MockListener(this.mockmessagebus
				.getSession()));
	}

	@Test
	public void testGetVersionCall() throws JMSException {
		final MessageBus messagebus = new MessageBusLocal();
		final ConfigurationRest v = new ConfigurationRest(
				messagebus.getSession(), messagebus.getProducer());

		Assert.assertEquals(ConfigurationRestTest.EXPECTED,
				v.getValue("getVersion"));
	}
}