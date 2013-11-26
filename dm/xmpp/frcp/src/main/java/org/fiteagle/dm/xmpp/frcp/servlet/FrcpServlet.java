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
	private static final String USER = "test1";
	private static final String PWD = "test";
	private static final String SERVER = "localhost";
	private static final String PROTOCOL = "xmpp://";
	private static final String SERVICE = "";

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

	private XMPPConnection connect(String host, int port, String user,
			String password) throws XMPPException {
		ConnectionConfiguration config = new ConnectionConfiguration(host, port);
		XMPPConnection conn = new XMPPConnection(config);
		conn.connect();

		try {
			conn.getAccountManager().createAccount(USER, PWD);
		} catch (XMPPException e) {
			log.log(Level.FINE, "User does already exist: " + USER);
		} finally {
			conn.login(USER, PWD, SERVICE);
		}

		return conn;
	}

	@Override
	public void contextInitialized(final ServletContextEvent sce) {
		FrcpServlet.log.log(Level.INFO, "Starting FRCP Servlet...");

		try {
			XMPPConnection xmppConnection = connect(SERVER, 5222, USER,
					PWD);
			final MessageBus jmsMessageBus = MessageBusApplicationServerFactory
					.createMessageBus();

			this.frcpListener = new FrcpListener(jmsMessageBus, xmppConnection);
			
			System.out.println("Starting FFF13 demo listener");
			xmppConnection = connect("fuseco.fokus.fraunhofer.de", 5222, "fiteagle", "test");
			FFFListener fffListener = new FFFListener(jmsMessageBus, xmppConnection);
			
		} catch (final Exception e) {
			FrcpServlet.log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
