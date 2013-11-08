package org.fiteagle.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageBusLogger {

	private static final Logger log = Logger.getLogger(MessageBusLogger.class
			.getName());

	private String lastTextMessage;
	private final int count;
	private final String content;

	{
		final Preferences prefs = Preferences
				.userNodeForPackage(MessageBusLogger.class);
		this.count = prefs.getInt("count", 1);
		this.content = prefs.get("content", "self test message");
	}

	public MessageBusLogger(final Session session,
			final MessageConsumer consumer, final MessageProducer producer)
			throws JMSException {

		MessageBusLogger.log.info("Sending " + this.count
				+ " messages with content: " + this.content);
		System.out.println("Sending " + this.count + " messages with content: "
				+ this.content);

		selfTest(session, consumer, producer);

		final MessageListener listener = new MessageBusLogger.MessagerListener();
		consumer.setMessageListener(listener);
	}

	private void selfTest(final Session session,
			final MessageConsumer consumer, final MessageProducer producer)
			throws JMSException {
		this.sendTestMessages(session, producer, this.count, this.content);
		this.receiveTestMessages(consumer, this.count);
	}

	private void receiveTestMessages(final MessageConsumer consumer,
			final int count) throws JMSException {
		TextMessage message;
		for (int i = 0; i < count; i++) {
			message = (TextMessage) consumer.receive(5000);
			if (null == message) {
				MessageBusLogger.log.info("Received message with no content!");
			} else {
				MessageBusLogger.log.info("Received message with content "
						+ message.getText());
			}
		}
	}

	private void sendTestMessages(final Session session,
			final MessageProducer producer, final int count,
			final String content) throws JMSException {
		TextMessage message;
		for (int i = 0; i < count; i++) {
			message = session.createTextMessage(content);
			producer.send(message);
		}
	}

	public String getLastTextMessage() {
		return this.lastTextMessage;
	}

	private class MessagerListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				MessageBusLogger.this.lastTextMessage = ((TextMessage) message)
						.getText();
			} catch (final JMSException e) {
				MessageBusLogger.log.log(Level.SEVERE, e.toString());
			}
		}
	}

}
