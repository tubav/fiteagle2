package org.fiteagle.core.logger;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.Test;

public class MessageBusLoggerTest {

	private static final String DEFAULT_DESTINATION = "jms/queue/fiteagle";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://localhost:8080";

	// @todo: mock/in-memory?

	@Test
	@Ignore
	public void testCommunicateWithJmsUsingMessageBusLogger() throws Exception {
		InitialContext jndiContext = createJndiContext();

		ConnectionFactory cFactory = null;
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		MessageConsumer consumer = null;
		Destination dest = null;

		String destinationString = System.getProperty("destination",
				DEFAULT_DESTINATION);

		dest = (Destination) jndiContext.lookup(destinationString);

		// Perform the JNDI lookups
		String connectionFactoryString = System.getProperty(
				"connection.factory", DEFAULT_CONNECTION_FACTORY);
		cFactory = (ConnectionFactory) jndiContext
				.lookup(connectionFactoryString);

		// Create the JMS connection, session, producer, and consumer
		connection = cFactory.createConnection(
				System.getProperty("username", DEFAULT_USERNAME),
				System.getProperty("password", DEFAULT_PASSWORD));

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = session.createProducer(dest);
		consumer = session.createConsumer(dest);
		connection.start();

		new MessageBusLogger(session, consumer, producer);
	}

	private InitialContext createJndiContext() throws NamingException {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL,
				System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", DEFAULT_USERNAME));
		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", DEFAULT_PASSWORD));
		InitialContext context = new InitialContext(env);
		return context;
	}

}
