package org.fiteagle.core.configuration.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.fiteagle.core.configuration.Configuration;
import org.fiteagle.core.messagebus.MessageBus;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static final Logger log = Logger.getLogger(Activator.class
			.getName());
	private MessageBus messageBus;
	public static final String DESTINATION_FITEAGLE = "java:/topic/fiteagle";
	public static final String CONNECTION_FACTORY_LOCAL = "java:/ConnectionFactory";

	
	
	@Override
	public void start(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Starting FITeagle Configuration...");
		
		final String username = "fiteagle";
		final String password = "fiteagle";

		final InitialContext jndiContext = new InitialContext();
		final ConnectionFactory factory = (ConnectionFactory) jndiContext
				.lookup(Activator.CONNECTION_FACTORY_LOCAL);

		final Destination destination = (Destination) jndiContext
				.lookup(Activator.DESTINATION_FITEAGLE);

		this.messageBus = new MessageBus(username, password, factory,
				destination);

		final Session session = this.messageBus.getSession();
		final MessageProducer producer = this.messageBus.getProducer();
		final MessageConsumer consumer = this.messageBus.getConsumer();

		new Configuration(session, consumer, producer);
		
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Stopping FITeagle Configuration...");
	}
}
