package org.fiteagle.dm.fff13;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBus.Type;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;

@ServerEndpoint("/fff13")
public class FFFWebSocket {
	private static final Logger LOGGER = Logger.getLogger(FFFWebSocket.class
			.getName());
	private Session socket;
	private final MessageBus bus;

	public FFFWebSocket() throws NamingException, JMSException {
		this(MessageBusApplicationServerFactory.createMessageBus());
	}

	public FFFWebSocket(final MessageBus bus) throws JMSException {
		this.bus = bus;
	}

	@OnClose
	public void onClose(final CloseReason reason) throws JMSException {
		FFFWebSocket.LOGGER.log(Level.INFO, "Closing a WebSocket due to "
				+ reason.getReasonPhrase());
		this.bus.close();
	}

	@OnOpen
	public void onOpen(final Session websocket) throws JMSException {
		FFFWebSocket.LOGGER.log(Level.INFO,
				"WebSocket opened: " + websocket.getId());
		FFFWebSocket.LOGGER.log(Level.INFO,
				"Query String: " + websocket.getQueryString());
		FFFWebSocket.LOGGER.log(Level.INFO,
				"URI: " + websocket.getRequestURI());
		FFFWebSocket.LOGGER.log(Level.INFO,
				"Path: " + websocket.getPathParameters());
		
		this.socket = websocket;
	}

	@OnMessage
	public String echoMessage(final String message) throws JMSException {
		FFFWebSocket.LOGGER.log(Level.INFO, "Received : " + message);

		String uid = "epc-enablers";
		String namespace = "";
		String type = Type.INFORM.toString();
		String jmsMessage = message;
		this.bus.sendMessage(uid, namespace, type, jmsMessage);		
		return "request sent";
	}
}
