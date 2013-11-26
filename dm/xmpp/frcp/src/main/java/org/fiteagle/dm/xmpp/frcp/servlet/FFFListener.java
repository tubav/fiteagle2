package org.fiteagle.dm.xmpp.frcp.servlet;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBus.Status;
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
		ItemEventListener<PayloadItem<SimplePayload>> {

	private XMPPConnection xmppBus;
	private MessageBus jmsBus;
	private XmppController controller;

	public FFFListener(MessageBus jmsBus, XMPPConnection xmppBus)
			throws XMPPException {
		this.jmsBus = jmsBus;
		this.xmppBus = xmppBus;
		this.controller = new XmppController(xmppBus);
		subscribe("epc-enablers");
	}

	private void subscribe(String topicName) throws XMPPException {
		LeafNode topic = controller.getTopic(topicName);
		topic.addItemEventListener(this);
		topic.subscribe(controller.getJid());
	}

	@Override
	public void handlePublishedItems(
			ItemPublishEvent<PayloadItem<SimplePayload>> items) {

		for (PayloadItem<SimplePayload> item : items.getItems()) {
			try {

				XmppReceiverDetails details = XmppController.getDetails(item);
				String uid = items.getNodeId();
				String namespace = details.getNamespace();
				String type = details.getElement();
				String message = item.getPayload().toXML();
				if (message.contains("epcQoSControl stop")) {
					System.out.println("stop");
					send(MessageBus.Status.UP);
				} else if (message.contains("epcQoSControl start")
						|| message.contains("touch")) {
					System.out.println("start");
					send(MessageBus.Status.WARNING);
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	private void send(Status status) throws JMSException {
		TextMessage busmessage = this.jmsBus.getSession()
				.createTextMessage();

		busmessage.setStringProperty(
				MessageBus.Property.TYPE.toString(),
				MessageBus.Type.STATUSNOTIFICATION.toString());
		busmessage.setStringProperty(
				MessageBus.Property.UID.toString(), "Samsung S4");
		busmessage.setText(String.valueOf(status));
		this.jmsBus.getProducer().send(busmessage);
	}
}
