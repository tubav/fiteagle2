package org.fiteagle.dm.xmpp;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.fiteagle.boundary.MessageBus;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class XMPPListener implements ServletContextListener {

	private final Session session;
	private final MessageConsumer consumer;
	private final MessageProducer producer;
	private XMPPConnection xmppConnection;
	private static final Logger log = Logger.getLogger(XMPPListener.class.getName());

	public XMPPListener() throws NamingException, JMSException, XMPPException {
		super();
		MessageBus messageBus = new MessageBus();
		this.session = messageBus.getSession();
		this.consumer = messageBus.getConsumer();
		this.producer = messageBus.getProducer();
		startXmppListener();
	}

	public XMPPListener(final Session session, final MessageConsumer consumer,
			final MessageProducer producer) throws JMSException, XMPPException {
		final MessageListener listener = new XMPPListener.XMPPMessageBusListener();
		this.session = session;
		this.consumer = consumer;
		this.producer = producer;
		this.consumer.setMessageListener(listener);

		startXmppListener();
	}

	private void startXmppListener() throws XMPPException {
		ConnectionConfiguration config = new ConnectionConfiguration(
				"fuseco.fokus.fraunhofer.de", 5222, "fiteagle");

		xmppConnection = new XMPPConnection(config);
		xmppConnection.connect();
		xmppConnection.login("test", "test", "server");

		PubSubManager pubsub = new PubSubManager(xmppConnection);
		Node pubsubNode;
		pubsubNode = pubsub.getNode("test");
		pubsubNode.addItemEventListener(new XMPPNativeListener());
	}

	private class XMPPMessageBusListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				final String logMessage = "JMS Received: '" + textMessage.getText() + "'";
				XMPPListener.log.log(Level.INFO,logMessage);
			} catch (final JMSException e) {
				XMPPListener.log.log(Level.SEVERE, e.toString());
			}
		}
	}

	private class XMPPNativeListener implements
			ItemEventListener<PayloadItem<SimplePayload>> {
		@Override
		public void handlePublishedItems(
				ItemPublishEvent<PayloadItem<SimplePayload>> payload) {
			final String message = payload.getItems().get(0).getPayload()
					.toXML();
			XMPPListener.log.log(Level.INFO, "XMPP Received: '" + message + "'");
			try {
				producer.send(session.createTextMessage(message));
			} catch (JMSException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.log(Level.INFO, "Starting XMPP Listener...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.log(Level.INFO, "Stopping XMPP Listener...");
		this.xmppConnection.disconnect();
	}
}
