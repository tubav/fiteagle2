package org.fiteagle.dm.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/configuration")
public class ConfigurationWebSocket {

	public static final String DESTINATION_FITEAGLE = "java:/topic/fiteagle";
	public static final String CONNECTION_FACTORY_LOCAL = "java:/ConnectionFactory";
	private static final Logger LOGGER = Logger
			.getLogger(ConfigurationWebSocket.class.getName());

	private final javax.jms.Session session;
	private final MessageProducer producer;
	private Destination destination;

	public ConfigurationWebSocket() throws NamingException, JMSException {
		LOGGER.log(Level.INFO, "Starting FITeagle WebSocket Interface...");

		final String username = "fiteagle";
		final String password = "fiteagle";

		final InitialContext jndiContext = new InitialContext();
		final ConnectionFactory factory = (ConnectionFactory) jndiContext
				.lookup(CONNECTION_FACTORY_LOCAL);

		this.destination = (Destination) jndiContext
				.lookup(DESTINATION_FITEAGLE);

		Connection connection = factory.createConnection(username, password);
		this.session = connection
				.createSession(false, Session.AUTO_ACKNOWLEDGE);

		this.producer = session.createProducer(destination);

		connection.start();
	}

	public ConfigurationWebSocket(javax.jms.Session session,
			MessageProducer producer) {
		this.session = session;
		this.producer = producer;
	}

	@OnMessage
	public String onMessage(String message) throws JMSException {
		LOGGER.log(Level.INFO, "Received : " + message);
		TemporaryQueue responseDestination = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session
				.createConsumer(responseDestination);
		final TextMessage textMessage = this.session.createTextMessage(message);
		textMessage.setJMSReplyTo(responseDestination);
		
		this.producer.send(textMessage);
		
		String responseText = "";
		TextMessage response = (TextMessage) responseConsumer.receive(1000);
		if (null != response)
			responseText = response.getText();
		
		return responseText;
	}
}
