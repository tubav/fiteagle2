package org.fiteagle.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;

public class MessageBusLogger {

	private static final Logger log = Logger.getLogger(MessageBusLogger.class
			.getName());

	private String lastTextMessage;

	public MessageBusLogger(final Session session,
			final MessageConsumer consumer) throws JMSException {
		final MessageListener listener = new MessageBusLogger.MessagerListener();
		consumer.setMessageListener(listener);
	}

	public MessageBusLogger(final MessageBus messageBus) throws JMSException {
		this(messageBus.getSession(), messageBus.getConsumer());
	}

	public String getLastTextMessage() {
		return this.lastTextMessage;
	}

	private class MessagerListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				MessageBusLogger.this.lastTextMessage = textMessage.getText();
				MessageBusLogger.log.log(Level.INFO, "[MessageBus] Received: '"
						+ textMessage.getText() + "'");
				if (textMessage.getBooleanProperty("test")) {
					this.logTextMessage(textMessage);
				}
			} catch (final JMSException e) {
				MessageBusLogger.log.log(Level.SEVERE, e.toString());
			}
		}

		private void logTextMessage(final TextMessage textMessage)
				throws JMSException {
			final Level[] levels = { Level.ALL, Level.CONFIG, Level.FINE,
					Level.FINER, Level.FINEST, Level.INFO, Level.SEVERE,
					Level.WARNING };
			for (final Level level : levels) {
				MessageBusLogger.log.log(level, "[MessageBus] Test " + level
						+ " Received: '" + textMessage.getText() + "'");
			}
		}

	}

}
