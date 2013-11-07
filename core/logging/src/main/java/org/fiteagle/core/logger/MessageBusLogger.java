package org.fiteagle.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

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

	private static final String DEFAULT_MESSAGE = "Hello, World!";
	private static final String DEFAULT_MESSAGE_COUNT = "1";

	private String lastTextMessage;

	public MessageBusLogger(final Session session,
			final MessageConsumer consumer, final MessageProducer producer)
			throws JMSException {

		final int count = Integer.parseInt(System.getProperty("message.count",
				MessageBusLogger.DEFAULT_MESSAGE_COUNT));
		final String content = System.getProperty("message.content",
				MessageBusLogger.DEFAULT_MESSAGE);

		MessageBusLogger.log.info("Sending " + count
				+ " messages with content: " + content);
		System.out.println("Sending " + count + " messages with content: " 
				+ content);

		this.sendTestMessages(session, producer, count, content);
		this.receiveTestMessages(consumer, count);
		final MessageListener listener = new MessageBusLogger.MessagerListener();
		consumer.setMessageListener(listener);
	}

	private void receiveTestMessages(final MessageConsumer consumer,
			final int count) throws JMSException {
		TextMessage message;
		for (int i = 0; i < count; i++) {
			message = (TextMessage) consumer.receive(5000);
			MessageBusLogger.log.info("Received message with content "
					+ message.getText());
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
