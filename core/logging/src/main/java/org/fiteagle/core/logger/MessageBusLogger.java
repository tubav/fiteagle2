package org.fiteagle.core.logger;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageBusLogger {

	private static final Logger log = Logger.getLogger(MessageBusLogger.class
			.getName());

	private static final String DEFAULT_MESSAGE = "Hello, World!";
	private static final String DEFAULT_MESSAGE_COUNT = "3";

	public MessageBusLogger(Session session, MessageConsumer consumer,
			MessageProducer producer) throws JMSException {

		int count = Integer.parseInt(System.getProperty("message.count",
				DEFAULT_MESSAGE_COUNT));
		String content = System.getProperty("message.content", DEFAULT_MESSAGE);

		log.info("Sending " + count + " messages with content: " + content);
		System.out.println("Sending " + count + " messages with content: "
				+ content);

		sendTestMessages(session, producer, count, content);
		receiveTestMessages(consumer, count);
	}

	private void receiveTestMessages(MessageConsumer consumer, int count)
			throws JMSException {
		TextMessage message;
		for (int i = 0; i < count; i++) {
			message = (TextMessage) consumer.receive(5000);
			log.info("Received message with content " + message.getText());
		}
	}

	private void sendTestMessages(Session session, MessageProducer producer,
			int count, String content) throws JMSException {
		TextMessage message;
		for (int i = 0; i < count; i++) {
			message = session.createTextMessage(content);
			producer.send(message);
		}
	}
}
