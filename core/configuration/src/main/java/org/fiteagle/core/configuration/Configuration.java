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

	private static final String VERSION = "203";

	private final Session session;
	private final MessageConsumer consumer;
	private final MessageProducer producer;
	private MessageProducer specificProducer;
	private static final Logger log = Logger.getLogger(Configuration.class.getName());


	public Configuration(final Session session,
			final MessageConsumer consumer, final MessageProducer producer) throws JMSException {
		final MessageListener listener = new Configuration.ConfigurationListener();
		this.session = session;
		this.consumer = consumer;
		this.producer = producer;
		this.consumer.setMessageListener(listener);
		this.specificProducer = session.createProducer(null);
	}

	public Configuration(MessageBus messageBus) throws JMSException {
		this(messageBus.getSession(), messageBus.getConsumer(), messageBus.getProducer());
	}

	private class ConfigurationListener implements MessageListener {

		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				Configuration.log.log(Level.INFO, "[Configuration] Received: '"
						+ textMessage.getText() + "'");
				if (textMessage.getText().equals("getVersion")) {
					TextMessage result = session.createTextMessage(VERSION);
					result.setJMSCorrelationID(textMessage.getJMSCorrelationID());
					
					Configuration.log.log(Level.INFO, "[Configuration] Sending: '"
							+ result.getText() + "'");
					Destination replyTo = textMessage.getJMSReplyTo();
					
					if (null == replyTo)
						producer.send(result);
					else
						specificProducer.send(replyTo, result);
				}
			} catch (final JMSException e) {
				Configuration.log.log(Level.SEVERE, e.toString());
			}
		}
	}
}
