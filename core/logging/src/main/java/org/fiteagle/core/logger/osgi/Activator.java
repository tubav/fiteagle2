package org.fiteagle.core.logger.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

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

	private static final Logger log = Logger.getLogger(Activator.class
			.getName());

	@Override
	public void start(final BundleContext context) throws Exception {
		log.log(Level.INFO, "Starting FITeagle MessageBus Logger...");

		String username = "fiteagle";
		String password = "fiteagle";

		InitialContext jndiContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) jndiContext
				.lookup(CONNECTION_FACTORY_LOCAL);

		Destination destination = (Destination) jndiContext
				.lookup(DESTINATION_FITEAGLE);

		this.messageBus = new MessageBus(username, password, factory,
				destination);

		final Session session = messageBus.getSession();
		final MessageProducer producer = messageBus.getProducer();
		final MessageConsumer consumer = messageBus.getConsumer();

		new MessageBusLogger(session, consumer);
		producer.send(session.createTextMessage("self test"));
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		log.log(Level.INFO, "Stopping FITeagle MessageBus Logger...");
		if (null != this.messageBus)
			this.messageBus.close();
	}
}
