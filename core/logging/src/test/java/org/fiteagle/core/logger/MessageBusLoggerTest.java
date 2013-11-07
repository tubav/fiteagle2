package org.fiteagle.core.logger;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.Test;

public class MessageBusLoggerTest {

	private static final String DEFAULT_DESTINATION = "jms/queue/fiteagle";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_USERNAME = "fiteagle";
	private static final String DEFAULT_PASSWORD = "fiteagle";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://localhost:8080";

	@Test
	@Ignore
	public void testCommunicateWithJmsUsingMessageBusLogger() throws Exception {
		InitialContext jndiContext = createJndiContext();
		new MessageBusLogger(jndiContext, DEFAULT_DESTINATION,
				DEFAULT_CONNECTION_FACTORY);
	}

	private InitialContext createJndiContext() throws NamingException {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL,
				System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", DEFAULT_USERNAME));
		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", DEFAULT_PASSWORD));
		InitialContext context = new InitialContext(env);
		return context;
	}

}
