package org.fiteagle.core.messagebus.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static final Logger log = Logger.getLogger(Activator.class
			.getName());

	@Override
	public void start(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Starting FITeagle MessageBus...");
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.log.log(Level.INFO, "Stopping FITeagle MessageBus...");
	}
}
