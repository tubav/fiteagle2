package org.fiteagle.dm.xmpp.frcp.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBus.Status;
import org.fiteagle.boundary.MessageBus.Type;
import org.fiteagle.dm.xmpp.frcp.XmppController;
import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class FFFListener implements
		ItemEventListener<PayloadItem<SimplePayload>>, MessageListener {

	private final MessageBus jmsBus;
	private final XmppController controller;
	private Status status;
	private static final Logger LOGGER = Logger.getLogger(FFFListener.class
			.getName());

	public FFFListener(final MessageBus jmsBus, final XMPPConnection xmppBus)
			throws XMPPException, JMSException {

		this.status = MessageBus.Status.UNKNOWN;

		this.controller = new XmppController(xmppBus);
		this.subscribeToXmppTopic("epc-enablers");

		this.jmsBus = jmsBus;
		this.subscribeToJmsEvent(Type.STATUSQUERY);
	}

	private void subscribeToJmsEvent(final Type type) throws JMSException {
		final String filter = MessageBus.getFilter(type);
		this.jmsBus.getConsumer(filter).setMessageListener(this);
	}

	private void subscribeToXmppTopic(final String topicName)
			throws XMPPException {
		final LeafNode topic = this.controller.getTopic(topicName);
		topic.addItemEventListener(this);
		topic.subscribe(this.controller.getJid());
	}

	@Override
	public void handlePublishedItems(
			final ItemPublishEvent<PayloadItem<SimplePayload>> items) {

		for (final PayloadItem<SimplePayload> item : items.getItems()) {
			try {
				final XmppReceiverDetails details = XmppController
						.getDetails(item);
				items.getNodeId();
				details.getNamespace();
				details.getElement();
				final String message = item.getPayload().toXML();
				if (message.contains("epcQoSControl stop")) {
					System.out.println("stop");
					this.status = MessageBus.Status.UP;
					this.sendStatus();
				} else if (message.contains("epcQoSControl start")
						|| message.contains("touch")) {
					System.out.println("start");
					this.status = MessageBus.Status.WARNING;
					this.sendStatus();
				}
			} catch (final JMSException e) {
				FFFListener.LOGGER.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	private void sendStatus() throws JMSException {
		final TextMessage busmessage = this.jmsBus.getSession()
				.createTextMessage();

		busmessage.setStringProperty(MessageBus.Property.TYPE.toString(),
				MessageBus.Type.STATUSNOTIFICATION.toString());
		busmessage.setStringProperty(MessageBus.Property.UID.toString(),
				"Samsung S4");
		busmessage.setText(String.valueOf(this.status));
		this.jmsBus.getProducer().send(busmessage);
	}

	@Override
	public void onMessage(final Message arg0) {
		try {
			this.sendStatus();
		} catch (final JMSException e) {
			FFFListener.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}
}
