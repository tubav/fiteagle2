package org.fiteagle.dm.ws;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Hello world!
 * 
 */

@ServerEndpoint("/fff13")
public class FFFWebSocket {

	private static final Logger LOGGER = Logger.getLogger(FFFWebSocket.class
			.getName());
	private Session wsSession;

	private class Foo extends TimerTask {
		
		private String status;
		private String resource;
		private JSONObject json = new JSONObject();

		public Foo(String resource, String status) {
			this.resource = resource;
			this.status = status;
		}
		@Override
		public void run() {
			try {
				json.put("resource", resource);
				json.put("status", status);
				wsSession.getBasicRemote().sendText(json.toString());
			} catch (IOException | JSONException e) {
				LOGGER.log(Level.SEVERE, e.getCause().toString());
			}
		}

	}

	@OnMessage
	public String echoMessage(final String message) {
		FFFWebSocket.LOGGER.log(Level.INFO, "Received : " + message);
		Timer timer = new Timer();
		timer.schedule(new Foo("OpenEPC", "-1"), 4000);
		timer.schedule(new Foo("OpenEPC", "2"), 8000);
		timer.schedule(new Foo("OpenEPC", "1"), 13000);
		timer.schedule(new Foo("OpenEPC", "0"), 19000);
		timer.schedule(new Foo("OpenMTC", "0"), 20000);
		timer.schedule(new Foo("OpenIMSCore", "2"), 24000);
		timer.schedule(new Foo("OpenSDNCore", "-1"), 5000);
		return "";
	}

	@OnClose
	public void onClose(final CloseReason reason) {
		FFFWebSocket.LOGGER.log(Level.INFO,
				"Closing a WebSocket due to " + reason.getReasonPhrase());
	}

	@OnOpen
	public void onOpen(final Session session) {
		FFFWebSocket.LOGGER.log(Level.INFO, "Received : " + "WebSocket opened: "
				+ session.getId());
		this.wsSession = session;
	}

}
