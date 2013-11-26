package org.fiteagle.dm.xmpp.frcp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.fiteagle.dm.xmpp.frcp.servlet.FrcpServlet;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.PacketExtension;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.SimplePayload;

public class XmppController {

	private final PubSubManager mgr;
	private final XMPPConnection connection;
	private static final Logger LOGGER = Logger.getLogger(XmppController.class
			.getName());

	public XmppController(final String host, final int port, final String user,
			final String password) throws XMPPException {
		this.connection = connect(host, port, user, password);
		this.mgr = this.getManager();
	}

	public XmppController(XMPPConnection xmppConnection) {
		this.connection = xmppConnection;
		this.mgr = this.getManager();
	}

	public PubSubManager getManager() {
		return new PubSubManager(this.connection);
	}
	
	public static XMPPConnection connect(String host, int port, String user, String password) throws XMPPException {
		final ConnectionConfiguration config = new ConnectionConfiguration(
				host, port);
		final XMPPConnection conn = new XMPPConnection(config);
		conn.connect();
		try {
			conn.getAccountManager().createAccount(user, password);
		} catch (XMPPException e) {
			e.printStackTrace();
		} finally {
			conn.login(user, password);
		}
		return conn;
	}

	public LeafNode getAndSubscribeTopic(String topic) throws XMPPException {
		
		LeafNode topicNode = this.getTopic(topic);
		
		String subscriber = this.getJid();
		LOGGER.log(Level.INFO, "Subscribing '"+subscriber+"' to '"+topic+"'");
		topicNode.subscribe(subscriber);
		
		return topicNode;
	}

	public LeafNode getTopic(String topic) throws XMPPException {
		LOGGER.log(Level.INFO, "Getting topic '"+topic+"'");
		LeafNode topicNode;
		ConfigureForm config = creatConfiguration();
		try {
			this.mgr.createNode(topic, config);
		} catch (XMPPException e) {
			// already exists
		} finally {
			topicNode = this.mgr.getNode(topic);
		}
		return topicNode;
	}

	
	private ConfigureForm creatConfiguration() {
		ConfigureForm config = new ConfigureForm(FormType.submit);
		config.setAccessModel(AccessModel.open);
		config.setDeliverPayloads(true);
		config.setNotifyRetract(true);
		config.setPersistentItems(false);
		config.setPublishModel(PublishModel.open);
		return config;
	}

	public static void sendTextMessage(LeafNode topic, String message) {
		sendTextMessage(topic, message, "", "");
	}


	public static void sendTextMessage2(LeafNode topic, String message) throws XMPPException {
		String element = "";
		String namespace = "";
		SimplePayload payload = new SimplePayload(element, namespace , message);
		topic.send(new PayloadItem<SimplePayload>(payload));
	}

	
	
	public static void sendTextMessage(LeafNode topic, String message, String namespace, String element) {
		System.out.println("Sending: " + message);
		SimplePayload payload = new SimplePayload(element, namespace, message);
		PayloadItem<SimplePayload> payloadItem = new PayloadItem<SimplePayload>(
				payload);
		topic.publish(new PayloadItem<PacketExtension>(payloadItem));
	}

	public static XmppReceiverDetails getDetails(PayloadItem<SimplePayload> item) {
		String element = item.getPayload().getElementName();
		String namespace = item.getPayload().getNamespace();
		return new XmppReceiverDetails(element, namespace);
	}

	public static class XmppReceiverDetails {
		private String namespace;
		private String element;

		public XmppReceiverDetails(String element, String namespace) {
			this.element = element;
			this.namespace = namespace;
		}

		public String getNamespace() {
			return this.namespace;
		}

		public String getElement() {
			return this.element;
		}
		@Override
		public String toString() {
			return toString(this);
		}

		public static String toString(XmppReceiverDetails details) {
			String result = "";
			result += details.getNamespace() + "#" + details.getElement();
			return result;
		}

	}

	public static PayloadItem<SimplePayload> getSimpleMessage(String text) {
		SimplePayload reply = new SimplePayload("", "",
				text);
		return new PayloadItem<SimplePayload>("", reply);
	
	}

	public String getJid() {
		return this.connection.getUser();
	}

}
