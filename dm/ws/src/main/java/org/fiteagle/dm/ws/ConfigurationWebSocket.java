package org.fiteagle.dm.ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;

@ServerEndpoint("/configuration")
public class ConfigurationWebSocket {

	private static final Logger LOGGER = Logger
			.getLogger(ConfigurationWebSocket.class.getName());

	private final javax.jms.Session session;
	private final MessageProducer producer;

	private MessageBus messagebus;

	public ConfigurationWebSocket() throws NamingException, JMSException {
		LOGGER.log(Level.INFO, "Starting FITeagle WebSocket Interface...");
		this.messagebus = MessageBusApplicationServerFactory.createMessageBus();
		this.session = messagebus.getSession();
		this.producer = messagebus.getProducer();
	}

	public ConfigurationWebSocket(javax.jms.Session session,
			MessageProducer producer) {
		this.session = session;
		this.producer = producer;
	}

	@OnMessage
	public String onMessage(String message) throws JMSException {
		LOGGER.log(Level.INFO, "Received : " + message);
		TemporaryQueue responseDestination = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session
				.createConsumer(responseDestination);
		final TextMessage textMessage = this.session.createTextMessage(message);
		textMessage.setJMSReplyTo(responseDestination);
		
		this.producer.send(textMessage);
		
		String responseText = "";
		TextMessage response = (TextMessage) responseConsumer.receive(1000);
		if (null != response)
			responseText = response.getText();
		
		return responseText;
	}
}
