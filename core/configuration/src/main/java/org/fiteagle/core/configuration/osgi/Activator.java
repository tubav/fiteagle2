package org.fiteagle.core.configuration.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.core.configuration.Configuration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static final Logger log = Logger.getLogger(Activator.class
			.getName());
	private MessageBus messageBus;
	
	@Override
	public void start(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Starting FITeagle Configuration...");
		
		this.messageBus = new MessageBus();

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
