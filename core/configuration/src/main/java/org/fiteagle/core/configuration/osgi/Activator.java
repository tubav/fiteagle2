package org.fiteagle.core.configuration.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;
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
		this.messageBus = MessageBusApplicationServerFactory.createMessageBus();
		new Configuration(messageBus);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Stopping FITeagle Configuration...");
		if (null != this.messageBus)
			this.messageBus.close();
	}
}
