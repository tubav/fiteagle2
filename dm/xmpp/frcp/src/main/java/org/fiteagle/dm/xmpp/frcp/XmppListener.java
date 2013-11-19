package org.fiteagle.dm.xmpp.frcp;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class XmppListener implements
		ItemEventListener<PayloadItem<SimplePayload>>, MessageListener {

	private MessageBus messagebus;
	private XmppController xmppController;
	private static final Logger LOGGER = Logger.getLogger(XmppListener.class
			.getName());

	@Override
	public void handlePublishedItems(
			ItemPublishEvent<PayloadItem<SimplePayload>> items) {
		try {
			for (PayloadItem<SimplePayload> item : items.getItems()) {
				XmppReceiverDetails details = XmppController.getDetails(item);
				String uid = items.getNodeId();
				String namespace = details.getNamespace();
				String type = details.getElement();
				String message = item.getPayload().toXML();
				messagebus.sendMessage(uid, namespace, type, message);
			}
		} catch (JMSException e) {
			LOGGER.log(Level.SEVERE, e.getCause().getMessage());
		}
	}

	public XmppListener(MessageBus messagebus, XMPPConnection xmppConnection)
			throws XMPPException, JMSException, NamingException {
		
		this.xmppController = new XmppController(xmppConnection);
		this.messagebus = messagebus;
		
		this.getAndSubscribeTopic(xmppConnection.getUser());		
	}

	public void getAndSubscribeTopic(String topic) throws XMPPException,
			JMSException, NamingException {
		
		LeafNode xmppNode = xmppController.getAndSubscribeTopic(topic);
		xmppNode.addItemEventListener(this);

		String jmsTopic = MessageBus.normalize(topic);
		String filter ="(uid='" + jmsTopic + "' AND protocol='xmpp')";
		MessageConsumer jmsNode = messagebus.getConsumer(filter);
		jmsNode.setMessageListener(this);
	}

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = ((TextMessage) message);
			String protocol = textMessage.getStringProperty("protocol");
			boolean isReply = protocol != null && protocol.equalsIgnoreCase("xmpp"); 
			if (isReply) {	
				String uid = textMessage.getStringProperty("uid");
				String reply = textMessage.getText();
				LeafNode receiver = this.xmppController.getTopic(uid);
				receiver.send(XmppController.getSimpleMessage(reply));
			} else {
				LOGGER.log(Level.INFO, "received a non-reply!");
			}
		} catch (JMSException | XMPPException e) {
			LOGGER.log(Level.SEVERE, e.getCause().getMessage());
		}
	}
}
