package org.fiteagle.core.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Configuration {

	private final Session session;
	private final MessageConsumer consumer;
	private final MessageProducer producer;
	private static final Logger log = Logger.getLogger(Configuration.class.getName());


	public Configuration(final Session session,
			final MessageConsumer consumer, final MessageProducer producer) throws JMSException {
		final MessageListener listener = new Configuration.ConfigurationListener();
		this.session = session;
		this.consumer = consumer;
		this.producer = producer;
		this.consumer.setMessageListener(listener);
	}

	private class ConfigurationListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				Configuration.log.log(Level.INFO, "[Configuration] Received: '"
						+ textMessage.getText() + "'");
				String type = message.getStringProperty("type");
				if (null != type && type.equals("getVersion")) {
					TextMessage result = session.createTextMessage("123");
					result.setStringProperty("type", "setVersion");
					Configuration.log.log(Level.INFO, "[Configuration] Sending: '"
							+ result.getText() + "'");
					producer.send(result);
				}
			} catch (final JMSException e) {
				Configuration.log.log(Level.SEVERE, e.toString());
			}
		}
	}
}
