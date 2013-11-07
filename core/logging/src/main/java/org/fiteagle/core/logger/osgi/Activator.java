package org.fiteagle.core.logger.osgi;

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

import org.fiteagle.core.logger.MessageBusLogger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";
	private static final String DEFAULT_CONNECTION_FACTORY = "java:/ConnectionFactory";
	private static final String DEFAULT_DESTINATION = "java:/queue/fiteagle";

	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("FITeagle MessageBus Logger started");

		final InitialContext jndiContext = this.getContext();
		final Destination dest = this.getDestination(jndiContext);
		final Session session = this.getSession(jndiContext);
		final MessageProducer producer = session.createProducer(dest);
		final MessageConsumer consumer = session.createConsumer(dest);

		new MessageBusLogger(session, consumer, producer);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		System.out.println("FITeagle MessageBus Logger stopped");
	}

	private Destination getDestination(final InitialContext jndiContext)
			throws NamingException {
		Destination dest;
		final String destinationString = System.getProperty("destination",
				Activator.DEFAULT_DESTINATION);

		dest = (Destination) jndiContext.lookup(destinationString);
		return dest;
	}

	private Session getSession(final InitialContext jndiContext)
			throws NamingException, JMSException {
		ConnectionFactory cFactory;
		Connection connection;
		Session session;
		// Perform the JNDI lookups
		final String connectionFactoryString = System.getProperty(
				"connection.factory", Activator.DEFAULT_CONNECTION_FACTORY);
		cFactory = (ConnectionFactory) jndiContext
				.lookup(connectionFactoryString);

		// Create the JMS connection, session, producer, and consumer
		connection = cFactory.createConnection(
				System.getProperty("username", Activator.DEFAULT_USERNAME),
				System.getProperty("password", Activator.DEFAULT_PASSWORD));

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
		return session;
	}

	private InitialContext getContext() throws NamingException {
		final Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", Activator.DEFAULT_USERNAME));
		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", Activator.DEFAULT_PASSWORD));
		final InitialContext context = new InitialContext(env);
		return context;
	}

}
