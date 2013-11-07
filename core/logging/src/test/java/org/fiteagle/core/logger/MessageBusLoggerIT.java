package org.fiteagle.core.logger;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.Test;

public class MessageBusLoggerIT {

	private static final String DEFAULT_DESTINATION = "jms/topic/fiteagle";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://localhost:8080";

	@Test
	@Ignore
	// todo: convert to maven integration test
	public void testCommunicateWithJmsUsingMessageBusLogger() throws Exception {
		final InitialContext context = this.getContext();
		final Destination dest = this.getDestination(context);
		final Session session = this.getSession(context);
		final MessageProducer producer = session.createProducer(dest);
		final MessageConsumer consumer = session.createConsumer(dest);

		new MessageBusLogger(session, consumer, producer);
	}

	private Destination getDestination(final InitialContext jndiContext)
			throws NamingException {
		Destination dest;
		final String destinationString = System.getProperty("destination",
				MessageBusLoggerIT.DEFAULT_DESTINATION);

		dest = (Destination) jndiContext.lookup(destinationString);
		return dest;
	}

	private Session getSession(final InitialContext jndiContext)
			throws NamingException, JMSException {
		ConnectionFactory cFactory;
		Connection connection;
		Session session;
		final String connectionFactoryString = System.getProperty(
				"connection.factory",
				MessageBusLoggerIT.DEFAULT_CONNECTION_FACTORY);
		cFactory = (ConnectionFactory) jndiContext
				.lookup(connectionFactoryString);

		connection = cFactory.createConnection(System.getProperty("username",
				MessageBusLoggerIT.DEFAULT_USERNAME), System.getProperty(
				"password", MessageBusLoggerIT.DEFAULT_PASSWORD));

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
		return session;
	}

	private InitialContext getContext() throws NamingException {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				MessageBusLoggerIT.INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL,
				MessageBusLoggerIT.PROVIDER_URL));
		env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username",
				MessageBusLoggerIT.DEFAULT_USERNAME));
		env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password",
				MessageBusLoggerIT.DEFAULT_PASSWORD));
		final InitialContext context = new InitialContext(env);
		return context;
	}
}
