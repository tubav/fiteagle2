package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlException;
import org.fiteagle.boundary.MessageBus;
import org.fiteagle.dm.xmpp.frcp.FrcpXmppParser.FRCPMessageType;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.xml.sax.SAXException;

public class FrcpListener {
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

			FrcpListener.log.log(Level.INFO, "XMPP: received:");
			final String message = payload.getItems().get(0).getPayload()
					.toXML();
			FrcpListener.log.log(Level.INFO, message);

			try {

				FRCPMessageType type = FrcpXmppParser.getType(message);

				if (type.equals(FRCPMessageType.REQUEST)) {
					RequestDocument request = RequestDocument.Factory
							.parse(message);
					InformDocument result = (InformDocument) frcp
							.handle(request);

					System.out.println(result);

					for (String receiver2 : request.getRequest().getSrcArray()) {
						String topic = receiver2.replace(protocol, "").replace(
								"@" + server, "");

						FrcpListener.log.log(Level.INFO,
								"Subscribing to XMPP topic: '" + topic + "'");
						final LeafNode clientNode = xmppMessageBus
								.getNode(topic);
						clientNode.subscribe(id);
						xmppMessageBus.getNode(topic).addItemEventListener(
								new XmppMessageBusListener());

						final LeafNode targetNode = xmppMessageBus
								.getNode(username);
						FrcpListener.log.log(Level.INFO,
								"Sending XMPP message to '" + username + "': '"
										+ result + "'");

						final SimplePayload payload2 = new SimplePayload("",
								"", result.toString());
						targetNode.send(new PayloadItem<SimplePayload>("",
								payload2));
					}
				} else {
					// final TextMessage jmsMessage =
					// FrcpListener.this.jmsMessageBus
					// .getSession().createTextMessage("Unkown: " + message);
					// FrcpListener.this.jmsMessageBus.getProducer().send(jmsMessage);
				}

			} catch (final ParserConfigurationException | SAXException
					| IOException | XmlException | XMPPException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private XMPPConnection xmppConnection;
	private final MessageBus jmsMessageBus;
	private String username;
	private String server;
	private String protocol;
	private String id;
	private FrcpController frcp;

	private final PubSubManager xmppMessageBus;

	private static final Logger log = Logger.getLogger(FrcpListener.class
			.getName());

	public FrcpListener(MessageBus messageBus, XMPPConnection xmppConnection,
			String protocol, String username, String server)
			throws JMSException, XMPPException {
		this.server = server;
		this.protocol = protocol;
		this.username = username;
		this.id = username + "@" + server;

		this.jmsMessageBus = messageBus;
		this.startJMSListener();

		this.xmppMessageBus = new PubSubManager(xmppConnection);
		this.startXmppListener(this.username);
		this.frcp = new FrcpController(protocol, username, server);
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

	private void startJMSListener() throws JMSException {
		this.jmsMessageBus.getConsumer().setMessageListener(
				new FrcpListener.JmsMessageBusListener());
	}

	private void startXmppListener(final String topic) throws XMPPException {
		log.log(Level.INFO, "XMPP: subscribing to '" + topic + "'");
		try {
			this.xmppMessageBus.createNode(topic).addItemEventListener(
					new XmppMessageBusListener());
		} catch (XMPPException e) {
			//
		} finally {
			this.xmppMessageBus.getNode(topic).addItemEventListener(
					new XmppMessageBusListener());
		}
	}
}
