package org.fiteagle.dm.xmpp.chat.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;
import org.fiteagle.dm.xmpp.chat.ChatListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

public class ChatServlet implements ServletContextListener {

	private static final Logger log = Logger.getLogger(ChatServlet.class
			.getName());
	private MessageBus messageBus;
	private ChatListener chatListener;

	@Override
	public void contextDestroyed(final ServletContextEvent sce) {
		ChatServlet.log.log(Level.INFO, "Stopping XMPP Chat Listener...");
		if (null != this.chatListener) {
			this.chatListener.close();
		}
		try {
			if (null != this.messageBus) {
				this.messageBus.close();
			}
		} catch (final JMSException e) {
			ChatServlet.log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void contextInitialized(final ServletContextEvent sce) {
		ChatServlet.log.log(Level.INFO, "Starting XMPP Chat Listener...");

		try {
			// todo: refactor this
			final ConnectionConfiguration config = new ConnectionConfiguration(
					"fuseco.fokus.fraunhofer.de", 5222, "fiteagle_chat");
			final XMPPConnection xmppConnection = new XMPPConnection(config);
			xmppConnection.connect();
			xmppConnection.login("logger", "test", "chat_server");

			this.chatListener = new ChatListener(
					MessageBusApplicationServerFactory.createMessageBus(),
					xmppConnection);
		} catch (final Exception e) {
			ChatServlet.log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
