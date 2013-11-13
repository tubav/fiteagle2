package org.fiteagle.boundary;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageBusApplicationServerFactory {
	public static final String DESTINATION_DEFAULT = "java:/topic/fiteagle";
	public static final String CONNECTION_FACTORY_LOCAL = "java:/ConnectionFactory";
	private static final String username = "fiteagle";
	private static final String password = "fiteagle";

	public static MessageBus createMessageBus() throws NamingException,
			JMSException {
		final InitialContext mycontext = new InitialContext();
		final ConnectionFactory myfactory = (ConnectionFactory) mycontext
				.lookup(MessageBusApplicationServerFactory.CONNECTION_FACTORY_LOCAL);
		final Destination mydestination = (Destination) mycontext
				.lookup(MessageBusApplicationServerFactory.DESTINATION_DEFAULT);
		final Connection myconnection = myfactory.createConnection(
				MessageBusApplicationServerFactory.username,
				MessageBusApplicationServerFactory.password);
		final Session mysession = myconnection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		myconnection.start();

		return new MessageBus(myfactory, myconnection, mysession, mydestination);
	}
}
