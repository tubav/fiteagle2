package org.fiteagle.dm.ws;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;

@ServerEndpoint("/log")
public class LoggerWebSocket {

	class MessageBusListener implements MessageListener {

		@Override
		public void onMessage(final Message arg0) {
			String message = "unknown";
			try {
				message = ((TextMessage) arg0).getText();
				LoggerWebSocket.this.wsSession.getBasicRemote().sendText(
						message);
			} catch (JMSException | IOException e) {
				LoggerWebSocket.LOGGER.log(Level.SEVERE, e.getMessage());
			}
		}

	}

	private static final Logger LOGGER = Logger.getLogger(LoggerWebSocket.class
			.getName());
	private final javax.jms.Session session;
	private final MessageProducer producer;
	private MessageBus messagebus;
	private final MessageConsumer consumer;
	private Session wsSession;

	// todo: refactor
	public LoggerWebSocket() throws NamingException, JMSException {
		LoggerWebSocket.LOGGER.log(Level.INFO,
				"Starting FITeagle Log WebSocket Interface...");
		this.messagebus = MessageBusApplicationServerFactory.createMessageBus();
		this.session = this.messagebus.getSession();
		this.producer = this.messagebus.getProducer();
		this.consumer = this.messagebus.getConsumer();

		final MessageListener messagebusListener = new MessageBusListener();
		this.consumer.setMessageListener(messagebusListener);
	}

	public LoggerWebSocket(final MessageBus messageBus) throws JMSException {
		this.session = messageBus.getSession();
		this.producer = messageBus.getProducer();
		this.consumer = messageBus.getConsumer();
	}

	@OnMessage
	public String onMessage(final String message) throws JMSException {
		LoggerWebSocket.LOGGER.log(Level.INFO, "Received : " + message);
		final TemporaryQueue responseDestination = this.session
				.createTemporaryQueue();
		final MessageConsumer responseConsumer = this.session
				.createConsumer(responseDestination);
		final TextMessage textMessage = this.session.createTextMessage(message);
		textMessage.setJMSReplyTo(responseDestination);

		this.producer.send(textMessage);

		String responseText = "I refuse to answer that!";
		final TextMessage response = (TextMessage) responseConsumer
				.receive(1000);
		if (null != response) {
			responseText = response.getText();
		}

		return responseText;
	}

	@OnOpen
	public void onOpen(final Session wsSession, final EndpointConfig config)
			throws IOException {
		this.wsSession = wsSession;
	}
}
