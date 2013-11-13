package org.fiteagle.boundary;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

public class MessageBus {

	private static final String DESTINATION_DEFAULT = "fiteagle";
	protected final ConnectionFactory factory;
	protected final Connection connection;
	protected final Session session;
	protected final Destination destination;

	public MessageBus (ConnectionFactory factory, Connection connection, Session session, Destination destination) throws JMSException {
		this.factory = factory;
		this.connection = connection;
		this.session = session;
		this.destination = destination;
		connection.start();
	}
	
	public MessageBus (ConnectionFactory customFactory) throws JMSException {
		this.factory = customFactory;
		this.connection = factory.createConnection();
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
		if (null != this.connection)
			this.connection.close();		
	}

	public MessageProducer getProducer() throws JMSException {
		return this.session.createProducer(this.destination);
	}

	public MessageConsumer getConsumer() throws JMSException {
		return this.session.createConsumer(this.destination);
	}

}
