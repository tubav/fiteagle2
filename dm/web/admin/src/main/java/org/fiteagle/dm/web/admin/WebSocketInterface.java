package org.fiteagle.dm.web.admin;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Hello world!
 * 
 */

@ServerEndpoint("/fiteagle")
public class WebSocketInterface {

	private static final Logger log = Logger.getLogger(WebSocketInterface.class
			.getName());

	@OnMessage
	public String echoMessage(String message) {
		log.log(Level.INFO, "Received : " + message);
		return message + "Echo";
	}

	@OnOpen
	public void onOpen(Session session) {
		log.log(Level.INFO,
				"Received : " + "WebSocket opened: " + session.getId());
	}

	@OnClose
	public void onClose(CloseReason reason) {
		log.log(Level.INFO,
				"Closing a WebSocket due to " + reason.getReasonPhrase());
	}
}
