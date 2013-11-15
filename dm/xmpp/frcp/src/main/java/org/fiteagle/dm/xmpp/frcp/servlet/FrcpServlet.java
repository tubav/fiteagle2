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
import org.jivesoftware.smack.XMPPException;

public class FrcpServlet implements ServletContextListener {

	private static final Logger log = Logger.getLogger(FrcpServlet.class
			.getName());
	private static final String USER = "test";
	private static final String PWD = "fiteaglepwd";
	private static final String SERVER = "fuseco.fokus.fraunhofer.de";
	private static final String PROTOCOL = "xmpp://";
	private static final String SERVICE = "frcp_servlet";
	
	private MessageBus messageBus;
	private FrcpListener frcpListener;

	@Override
	public void contextDestroyed(final ServletContextEvent sce) {
		FrcpServlet.log.log(Level.INFO, "Stopping XMPP Listener...");
		if (null != this.frcpListener) {
			this.frcpListener.close();
		}
		try {
			if (null != this.messageBus) {
				this.messageBus.close();
			}
		} catch (final JMSException e) {
			FrcpServlet.log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void contextInitialized(final ServletContextEvent sce) {
		FrcpServlet.log.log(Level.INFO, "Starting XMPP Listener...");
		
		try {
			ConnectionConfiguration config = new ConnectionConfiguration(SERVER, 5222, SERVICE);
			final XMPPConnection xmppConnection = new XMPPConnection(config);
			xmppConnection.connect();
			
			try {
				xmppConnection.getAccountManager().createAccount(USER, PWD);
			} catch (XMPPException e) {
				//
			}
				
			xmppConnection.login(USER, PWD, SERVICE);

			this.frcpListener = new FrcpListener(
					MessageBusApplicationServerFactory.createMessageBus(),
					xmppConnection, PROTOCOL, USER, SERVER);
		} catch (final Exception e) {
			FrcpServlet.log.log(Level.SEVERE, e.getMessage());
		}
	}
}
