package org.fiteagle.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageBusLogger {

	private static final Logger log = Logger.getLogger(MessageBusLogger.class
			.getName());

	private String lastTextMessage;

	public MessageBusLogger(final Session session,
			final MessageConsumer consumer) throws JMSException {
		final MessageListener listener = new MessageBusLogger.MessagerListener();
		consumer.setMessageListener(listener);
	}

	public String getLastTextMessage() {
		return this.lastTextMessage;
	}

	private class MessagerListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final String textMessage = ((TextMessage) message).getText();
				MessageBusLogger.this.lastTextMessage = textMessage;
				MessageBusLogger.log.log(Level.INFO, "[MessageBus] Received: '"
						+ textMessage + "'");
			} catch (final JMSException e) {
				MessageBusLogger.log.log(Level.SEVERE, e.toString());
			}
		}
	}

}
