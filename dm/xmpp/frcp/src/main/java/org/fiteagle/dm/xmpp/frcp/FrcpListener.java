package org.fiteagle.dm.xmpp.frcp;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class FrcpListener {
	private XMPPConnection xmppConnection;
	private final MessageBus jmsMessageBus;
	private final PubSubManager xmppMessageBus;
	private static final Logger log = Logger.getLogger(FrcpListener.class
			.getName());

	public FrcpListener(final MessageBus messageBus,
			final XMPPConnection xmppConnection) throws JMSException,
			XMPPException {

		this.jmsMessageBus = messageBus;
		this.startJMSListener();

		this.xmppMessageBus = new PubSubManager(xmppConnection);
		this.startXmppListener("test");
	}

	private void startJMSListener() throws JMSException {
		this.jmsMessageBus.getConsumer().setMessageListener(
				new FrcpListener.JmsMessageBusListener());
	}

	private void startXmppListener(final String topic) throws XMPPException {
		this.xmppMessageBus.getNode(topic).addItemEventListener(
				new XmppMessageBusListener());
	}

	public void close() {
		if (null != this.xmppConnection) {
			this.xmppConnection.disconnect();
		}
		if (null != this.jmsMessageBus) {
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
				final TextMessage jmsMessage = FrcpListener.this.jmsMessageBus
						.getSession().createTextMessage(message);
				FrcpListener.this.jmsMessageBus.getProducer().send(jmsMessage);
			} catch (final JMSException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
}
