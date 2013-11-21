package org.fiteagle.boundary;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

public class MessageBus {

	public static final String DESTINATION = "fiteagle";
	
	public static enum Type {
		STATUSNOTIFICATION("statusnotification");
		private final String type;
		
		Type(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return type;
		}
	}
	
	public static enum Property {
		TYPE("type"), UID("uid");
		private final String type;
		
		Property(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return type;
		}
	}
	
	public static enum Status {
		UNKNOWN(-1), UP(0), WARNING(1), ERROR(2);
		private final int status;

		Status(int status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return String.valueOf(status);
		}
	}

	protected final ConnectionFactory factory;
	protected final Connection connection;
	protected final Session session;
	protected final Destination destination;

	public MessageBus(final ConnectionFactory customFactory)
			throws JMSException {
		this.factory = customFactory;
		this.connection = this.factory.createConnection();
		this.session = this.connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		this.destination = this.session
				.createQueue(MessageBus.DESTINATION);
		this.connection.start();
	}

	public MessageBus(final ConnectionFactory factory,
			final Connection connection, final Session session,
			final Destination destination) throws JMSException {
		this.factory = factory;
		this.connection = connection;
		this.session = session;
		this.destination = destination;
		connection.start();
	}

	public void close() throws JMSException {
		if (null != this.connection) {
			this.connection.close();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public MessageConsumer getConsumer() throws JMSException {
		return this.session.createConsumer(this.destination);
	}

	public Destination getDestination() throws NamingException {
		return this.destination;
	}

	public ConnectionFactory getFactory() throws NamingException {
		return this.factory;
	}

	public MessageProducer getProducer() throws JMSException {
		return this.session.createProducer(this.destination);
	}

	public Session getSession() {
		return this.session;
	}

	public MessageConsumer getConsumer(String filter) throws JMSException {
		return this.session.createConsumer(this.destination, filter);
	}

	public void sendTextMessage(String message, String key, String value) throws JMSException {
		TextMessage jmsMessage = this.session.createTextMessage(message);
		jmsMessage.setStringProperty(key, value);
		this.getProducer().send(jmsMessage);
	}

	public static String normalize(String topic) {
		return topic.replaceAll("[^a-zA-Z0-9]", "_");
	}

	public void sendMessage(String uid, String namespace, String type,
			String message) throws JMSException {
		TextMessage jmsMessage = getSession().createTextMessage();
		jmsMessage.setStringProperty("uid", uid);
		jmsMessage.setStringProperty("namespace", namespace);
		jmsMessage.setStringProperty("type", type);
		jmsMessage.setText(message);
		getProducer().send(jmsMessage);
	}

	public static String getFilter(String uid, String type, String namespace) {
		String filter = "uid='" + uid + "'" + " AND type='" + type + "'"
				+ " AND namespace='" + namespace + "'";
		return filter;
	}

	public static String getFilter(Type type) {
		return "type='"+type+"'";
	}
}
