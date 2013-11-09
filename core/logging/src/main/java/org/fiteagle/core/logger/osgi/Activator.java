package org.fiteagle.core.logger.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.fiteagle.core.logger.MessageBusLogger;
import org.fiteagle.core.messagebus.MessageBus;
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
		Activator.log.log(Level.INFO, "Starting FITeagle MessageBus Logger...");

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

		new MessageBusLogger(session, consumer);
		final TextMessage textMessage = session.createTextMessage("self test");
		textMessage.setBooleanProperty("test", true);
		producer.send(textMessage);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Stopping FITeagle MessageBus Logger...");
		if (null != this.messageBus) {
			this.messageBus.close();
		}
	}
}
