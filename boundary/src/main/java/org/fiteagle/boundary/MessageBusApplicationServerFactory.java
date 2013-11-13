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
	
	public static MessageBus createMessageBus() throws NamingException, JMSException {
		InitialContext mycontext = new InitialContext();
		ConnectionFactory myfactory = (ConnectionFactory) mycontext
				.lookup(MessageBusApplicationServerFactory.CONNECTION_FACTORY_LOCAL);
		Destination mydestination = (Destination) mycontext
		.lookup(MessageBusApplicationServerFactory.DESTINATION_DEFAULT);
		Connection myconnection = myfactory.createConnection(username, password);
		Session mysession = myconnection
				.createSession(false, Session.AUTO_ACKNOWLEDGE);
		myconnection.start();
		
		return new MessageBus(myfactory, myconnection, mysession, mydestination);
	}
}
