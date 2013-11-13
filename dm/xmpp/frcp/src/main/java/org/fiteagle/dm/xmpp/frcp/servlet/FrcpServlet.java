package org.fiteagle.dm.xmpp.frcp.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.dm.xmpp.frcp.FrcpListener;

public class FrcpServlet implements ServletContextListener {

	private static final Logger log = Logger.getLogger(FrcpServlet.class.getName());
	private MessageBus messageBus;
	private FrcpListener frcpListener;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.log(Level.INFO, "Starting XMPP Listener...");
		try {
			this.messageBus = new MessageBus();
			Session session = messageBus.getSession();
			MessageConsumer consumer = messageBus.getConsumer();
			MessageProducer producer = messageBus.getProducer();
			this.frcpListener = new FrcpListener(session, consumer, producer);
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
