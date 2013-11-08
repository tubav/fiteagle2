package org.fiteagle.core.logger.osgi;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.fiteagle.core.logger.MessageBus;
import org.fiteagle.core.logger.MessageBusLogger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private MessageBus messageBus;
	public static final String DESTINATION_FITEAGLE = "java:/topic/fiteagle";
	public static final String CONNECTION_FACTORY_LOCAL = "java:/ConnectionFactory";

	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("Starting FITeagle MessageBus Logger...");
		
		String username = "fiteagle";
		String password = "fiteagle";
		
		InitialContext jndiContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) jndiContext
				.lookup(CONNECTION_FACTORY_LOCAL);

		Destination destination = (Destination) jndiContext.lookup(DESTINATION_FITEAGLE);
		
		this.messageBus = new MessageBus(username, password,
				 factory, destination);

		final Session session = messageBus.getSession();
		final MessageProducer producer = messageBus.getProducer();
		final MessageConsumer consumer = messageBus.getConsumer();

		new MessageBusLogger(session, consumer, producer);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		System.out.println("Stopping FITeagle MessageBus Logger...");
		this.messageBus.close();
	}
}
