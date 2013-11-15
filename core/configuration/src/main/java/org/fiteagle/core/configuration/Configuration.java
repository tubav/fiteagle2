package org.fiteagle.core.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;

public class Configuration {

	private class ConfigurationListener implements MessageListener {

		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				Configuration.log.log(Level.INFO, "[Configuration] Received: '"
						+ textMessage.getText() + "'");
				if (textMessage.getText().equals("getVersion")) {
					final TextMessage result = Configuration.this.session
							.createTextMessage(Configuration.VERSION);
					result.setJMSCorrelationID(textMessage
							.getJMSCorrelationID());

					Configuration.log.log(Level.INFO,
							"[Configuration] Sending: '" + result.getText()
									+ "'");
					final Destination replyTo = textMessage.getJMSReplyTo();

					if (null == replyTo) {
						Configuration.this.producer.send(result);
					} else {
						Configuration.this.specificProducer.send(replyTo,
								result);
					}
				}
			} catch (final JMSException e) {
				Configuration.log.log(Level.SEVERE, e.toString());
			}
		}
	}

	private static final String VERSION = "1337";
	private final Session session;
	private final MessageConsumer consumer;
	private final MessageProducer producer;
	private final MessageProducer specificProducer;

	private static final Logger log = Logger.getLogger(Configuration.class
			.getName());

	public Configuration(final MessageBus messageBus) throws JMSException {
		this(messageBus.getSession(), messageBus.getConsumer(), messageBus
				.getProducer());
	}

	public Configuration(final Session session, final MessageConsumer consumer,
			final MessageProducer producer) throws JMSException {
		final MessageListener listener = new Configuration.ConfigurationListener();
		this.session = session;
		this.consumer = consumer;
		this.producer = producer;
		this.consumer.setMessageListener(listener);
		this.specificProducer = session.createProducer(null);
	}
}
