package org.fiteagle.core.logger.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;
import org.fiteagle.core.logger.MessageBusLogger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private MessageBus messageBus;

	private static final Logger log = Logger.getLogger(Activator.class
			.getName());

	@Override
	public void start(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Starting FITeagle MessageBus Logger...");

		this.messageBus = MessageBusApplicationServerFactory.createMessageBus();

		final Session session = this.messageBus.getSession();
		final MessageProducer producer = session.createProducer(this.messageBus
				.getDestination());
		final MessageConsumer consumer = session.createConsumer(this.messageBus
				.getDestination());

		new MessageBusLogger(session, consumer);
		final TextMessage textMessage = session.createTextMessage("self test");
		textMessage.setBooleanProperty("test", true);
		producer.send(textMessage);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Stopping FITeagle MessageBus Logger...");
		if (null != this.messageBus) {
			this.messageBus.getConnection().close();
		}
	}
}
