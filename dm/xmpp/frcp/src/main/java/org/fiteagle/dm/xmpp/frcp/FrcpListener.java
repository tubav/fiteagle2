package org.fiteagle.dm.xmpp.frcp;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

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

public class FrcpListener {

	private final Session jmsSession;
	private final MessageConsumer jmsConsumer;
	private final MessageProducer jmsProducer;
	private XMPPConnection xmppConnection;
	private MessageBus jmsMessageBus;
	private Node xmppTopic;
	private PubSubManager xmppMessageBus;
	private static final Logger log = Logger.getLogger(FrcpListener.class
			.getName());

	public FrcpListener(final MessageBus messageBus) throws JMSException,
			XMPPException {
		this(messageBus.getSession(), messageBus.getConsumer(), messageBus
				.getProducer());
	}

	public FrcpListener(final Session session, final MessageConsumer consumer,
			final MessageProducer producer) throws JMSException, XMPPException {

		this.jmsSession = session;
		this.jmsConsumer = consumer;
		this.jmsProducer = producer;

		this.startJMSListener();
		this.startXmppListener();
	}

	private void startJMSListener() throws JMSException {
		this.jmsConsumer
				.setMessageListener(new FrcpListener.JmsMessageBusListener());
	}

	private void startXmppListener() throws XMPPException {
		final ConnectionConfiguration config = new ConnectionConfiguration(
				"fuseco.fokus.fraunhofer.de", 5222, "fiteagle");
		final String xmppTopic = "test";

		xmppConnect(config);
		xmppSubscribeTopic(xmppTopic);
	}

	private void xmppSubscribeTopic(final String xmppTopic)
			throws XMPPException {
		this.xmppTopic = this.xmppMessageBus.getNode(xmppTopic);
		this.xmppTopic.addItemEventListener(new XmppMessageBusListener());
	}

	private void xmppConnect(final ConnectionConfiguration config)
			throws XMPPException {
		this.xmppConnection = new XMPPConnection(config);
		this.xmppConnection.connect();
		this.xmppConnection.login("test", "test", "server");
		this.xmppMessageBus = new PubSubManager(this.xmppConnection);
	}

	public void close() {
		if (null != this.xmppConnection) {
			this.xmppConnection.disconnect();
		}
		if (null != this.jmsSession) {
			try {
				this.jmsMessageBus.close();
			} catch (final JMSException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	private class JmsMessageBusListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				final String logMessage = "JMS Received: '"
						+ textMessage.getText() + "'";
				FrcpListener.log.log(Level.INFO, logMessage);
			} catch (final JMSException e) {
				FrcpListener.log.log(Level.SEVERE, e.toString());
			}
		}
	}

	private class XmppMessageBusListener implements
			ItemEventListener<PayloadItem<SimplePayload>> {
		@Override
		public void handlePublishedItems(
				final ItemPublishEvent<PayloadItem<SimplePayload>> payload) {
			final String message = payload.getItems().get(0).getPayload()
					.toXML();
			FrcpListener.log
					.log(Level.INFO, "XMPP Received: '" + message + "'");
			try {
				FrcpListener.this.jmsProducer.send(FrcpListener.this.jmsSession
						.createTextMessage(message));
			} catch (final JMSException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
}
