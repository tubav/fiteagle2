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

import org.fiteagle.boundary.MessageBus;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class XMPP implements Runnable {

	private final Session session;
	private final MessageConsumer consumer;
	private final MessageProducer producer;
	private MessageProducer specificProducer;
	private static final Logger log = Logger.getLogger(XMPP.class.getName());

	public XMPP() throws NamingException, JMSException, XMPPException {
		super();
		MessageBus messageBus = new MessageBus();
		this.session = messageBus.getSession();
		this.consumer = messageBus.getConsumer();
		this.producer = messageBus.getProducer();
		startXmppListener();
	}

	public XMPP(final Session session, final MessageConsumer consumer,
			final MessageProducer producer) throws JMSException, XMPPException {
		final MessageListener listener = new XMPP.XMPPMessageBusListener();
		this.session = session;
		this.consumer = consumer;
		this.producer = producer;
		this.consumer.setMessageListener(listener);
		this.specificProducer = session.createProducer(null);

		startXmppListener();
	}

	private void startXmppListener() throws XMPPException {
		Connection connection = new XMPPConnection("fuseco.fokus.fraunhofer.de");
		connection.connect();
		connection.login("test", "test");

		PubSubManager pubsub = new PubSubManager(connection);
		Node pubsubNode;
		pubsubNode = pubsub.getNode("test");
		pubsubNode.addItemEventListener(new XMPPNativeListener());
	}

	private class XMPPMessageBusListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				XMPP.log.log(Level.INFO,
						"[XMPP] JMS Received: '" + textMessage.getText() + "'");
			} catch (final JMSException e) {
				XMPP.log.log(Level.SEVERE, e.toString());
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
			XMPP.log.log(Level.INFO, "[XMPP] XMPP Received: '" + message + "'");
			try {
				producer.send(session.createTextMessage(message));
			} catch (JMSException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		System.out.print("Listening for XMPP pubsub messages...");
		while (true) {
			try {
				System.out.print(".");
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}		
	}
}
