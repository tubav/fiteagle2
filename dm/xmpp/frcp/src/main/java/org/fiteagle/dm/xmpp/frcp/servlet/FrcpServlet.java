package org.fiteagle.dm.xmpp.frcp.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;
import org.fiteagle.dm.xmpp.frcp.FrcpListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

public class FrcpServlet implements ServletContextListener {

	private static final Logger log = Logger.getLogger(FrcpServlet.class.getName());
	private MessageBus messageBus;
	private FrcpListener frcpListener;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.log(Level.INFO, "Starting XMPP Listener...");
		
		try {
			//todo: refactor this
			ConnectionConfiguration config = new ConnectionConfiguration(
					"fuseco.fokus.fraunhofer.de", 5222, "fiteagle");
			XMPPConnection xmppConnection = new XMPPConnection(config);
			xmppConnection.connect();
			xmppConnection.login("test", "test", "server");
			
			this.frcpListener = new FrcpListener(MessageBusApplicationServerFactory.createMessageBus(), xmppConnection);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.log(Level.INFO, "Stopping XMPP Listener...");
		if (null != this.frcpListener)
			this.frcpListener.close();
		try {
			if (null != this.messageBus)
				this.messageBus.close();
		} catch (JMSException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
}
