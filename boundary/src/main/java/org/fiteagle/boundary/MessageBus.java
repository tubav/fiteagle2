package org.fiteagle.boundary;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageBus {
	public static final String DESTINATION_DEFAULT = "java:/topic/fiteagle";
	public static final String CONNECTION_FACTORY_LOCAL = "java:/ConnectionFactory";
	private final String username = "fiteagle";
	private final String password = "fiteagle";
	private final ConnectionFactory factory;
	private final Connection connection;
	private final Session session;
	private final Destination destination;

	public MessageBus() throws NamingException, JMSException {
		InitialContext context = new InitialContext();
		this.factory = (ConnectionFactory) context
				.lookup(MessageBus.CONNECTION_FACTORY_LOCAL);
		this.destination = (Destination) context
		.lookup(MessageBus.DESTINATION_DEFAULT);
		this.connection = factory.createConnection(username, password);
		this.session = connection
				.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
	}

	public MessageBus(ConnectionFactory customFactory) throws JMSException {
		this.factory = customFactory;
		this.connection = factory.createConnection(username, password);
		this.session = connection
				.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.destination = session.createQueue(DESTINATION_DEFAULT);
		connection.start();
	}


	public ConnectionFactory getFactory() throws NamingException {
		return this.factory;
	}

	public Destination getDestination() throws NamingException {
		return this.destination;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public Session getSession() {
		return this.session;
	}

	public void close() throws JMSException {
		this.connection.close();		
	}

	public MessageProducer getProducer() throws JMSException {
		return this.session.createProducer(this.destination);
	}

	public MessageConsumer getConsumer() throws JMSException {
		return this.session.createConsumer(this.destination);
	}
}
