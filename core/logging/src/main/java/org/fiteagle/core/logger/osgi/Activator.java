package org.fiteagle.core.logger.osgi;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.fiteagle.core.logger.MessageBusLogger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";
	private static final String DEFAULT_CONNECTION_FACTORY = "java:jboss/DefaultJMSConnectionFactory";
	private static final String DEFAULT_DESTINATION = "queue/fiteagle";
	
	
	public void start(BundleContext context) throws Exception {
		System.out.println("FITeagle MessageBus Logger started");

		InitialContext jndiContext = createJndiContext();

		new MessageBusLogger(jndiContext, DEFAULT_DESTINATION, DEFAULT_CONNECTION_FACTORY);
	}

	private InitialContext createJndiContext() throws NamingException {
		final Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", DEFAULT_USERNAME));
		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", DEFAULT_PASSWORD));
		InitialContext mbContext = new InitialContext(env);
		return mbContext;
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("FITeagle MessageBus Logger stopped");
	}

}
