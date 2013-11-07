package org.fiteagle.core.logger;

import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class MessageBusLogger {

	private static final Logger log = Logger.getLogger(MessageBusLogger.class
			.getName());

	// Set up all the default values
	private static final String DEFAULT_MESSAGE = "Hello, World!";
	private static final String DEFAULT_MESSAGE_COUNT = "1";
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";

	
		public MessageBusLogger(InitialContext context, 
				String destination,
				String connectionFactory) throws Exception {
		

		ConnectionFactory cFactory = null;
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		MessageConsumer consumer = null;
		TextMessage message = null;
		Destination dest = null;
		

		try {
			String destinationString = System.getProperty("destination", destination);

			dest = (Destination) context.lookup(destinationString);
			
			// Perform the JNDI lookups
			String connectionFactoryString = System.getProperty(
					"connection.factory", connectionFactory);
			log.info("Attempting to acquire connection factory \""
					+ connectionFactoryString + "\"");
			cFactory = (ConnectionFactory) context
					.lookup(connectionFactoryString);
			log.info("Found connection factory \"" + connectionFactoryString
					+ "\" in JNDI");


			// Create the JMS connection, session, producer, and consumer
			connection = cFactory.createConnection(
					System.getProperty("username", DEFAULT_USERNAME),
					System.getProperty("password", DEFAULT_PASSWORD));
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(dest);
			consumer = session.createConsumer(dest);
			connection.start();

			int count = Integer.parseInt(System.getProperty("message.count",
					DEFAULT_MESSAGE_COUNT));
			String content = System.getProperty("message.content",
					DEFAULT_MESSAGE);

			log.info("Sending " + count + " messages with content: " + content);
			System.out.println("Sending " + count + " messages with content: " + content);
			// Send the specified number of messages
			for (int i = 0; i < count; i++) {
				message = session.createTextMessage(content);
				producer.send(message);
			}

			// Then receive the same number of messages that were sent
			for (int i = 0; i < count; i++) {
				message = (TextMessage) consumer.receive(5000);
				log.info("Received message with content " + message.getText());
			}
		} catch (Exception e) {
			log.severe(e.getMessage());
			throw e;
		} finally {
			if (context != null) {
				context.close();
			}

			// closing the connection takes care of the session, producer, and
			// consumer
			if (connection != null) {
				connection.close();
			}
		}
	}
}
