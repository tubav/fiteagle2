package org.fiteagle.boundary;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageBusLocal extends MessageBus {
	private final static ConnectionFactory FACTORY = new ActiveMQConnectionFactory(
			"vm://localhost?broker.persistent=false");

	public MessageBusLocal() throws JMSException {
		super(MessageBusLocal.FACTORY);
	}

}
