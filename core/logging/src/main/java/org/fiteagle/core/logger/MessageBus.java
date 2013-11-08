package org.fiteagle.core.logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class MessageBus {

	private final Destination destination;
	private final Session session;

	private final Connection connection;

	public MessageBus(final String username, final String password,
			final ConnectionFactory factory, final Destination destination)
			throws JMSException {
		this.connection = factory.createConnection(username, password);
		this.session = this.connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		this.destination = destination;
		this.connection.start();
	}

	public MessageBus(final String username, final String password,
			final ConnectionFactory factory, final String destination)
			throws JMSException {
		this.connection = factory.createConnection(username, password);
		this.session = this.connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		this.destination = this.session.createTopic(destination);
		this.connection.start();
	}

	public Session getSession() throws JMSException {
		return this.session;
	}

	public MessageProducer getProducer() throws JMSException {
		return this.session.createProducer(this.destination);
	}

	public MessageConsumer getConsumer() throws JMSException {
		return this.session.createConsumer(this.destination);
	}

	public void close() throws JMSException {
		this.connection.close();
	}

}
