package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.ConfigureDocument;
import net.mytestbed.schema.omf.x60.protocol.CreateDocument;
import net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create;
import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform;
import net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype;
import net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlCursor;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FrcpListener {
	
	private static String RESOURCE_TOPIC = "test1";
	
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

	public String getMembershipFromConfigureMessage(final String xml)
			throws XmlException {
		String actual = "";

		final ConfigureDocument doc = ConfigureDocument.Factory.parse(xml);
		for (final Props prop : doc.getConfigure().getPropsArray()) {
			final NodeList childs = prop.getDomNode().getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				final org.w3c.dom.Node child = childs.item(i);
				actual = getTextFromNode(child, "membership");
			}
		}
		return actual.replace("xmpp://", "").replace("@" + "localhost", "");
	}

	private String getTextFromNode(final org.w3c.dom.Node child,
			final String expectedNodeName) {
		String text = "";
		final String nodeName = child.getLocalName();
		if (nodeName.equals(expectedNodeName) && child.hasChildNodes()) {
			text = child.getChildNodes().item(0).getNodeValue();
		}
		return text;
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
					RequestDocument request = RequestDocument.Factory.parse(message);
					InformDocument informDoc = (InformDocument) frcp.handle(request);

					final String informString = informDoc.toString();
					final String[] sources = request.getRequest().getSrcArray();

					subscribeTo(sources);
					
					final LeafNode target = xmppBus.getNode(RESOURCE_TOPIC);
					XmppController.sendTextMessage2(target, informString);

				} else if (type.equals(FRCPMessageType.CONFIGURE)) {
					System.out.println("CONFIGURE!");
					final String topic = getMembershipFromConfigureMessage(message);
					subscribeToMembership(topic);
					informAboutMembership(topic);
				} else if (type.equals(FRCPMessageType.CREATE)) {
					System.out.println("CREATE!");
					handleCreateApplicationMessage(message);
				} else {
					// final TextMessage jmsMessage =
					// FrcpListener.this.jmsMessageBus
					// .getSession().createTextMessage("Unkown: " + message);
					// FrcpListener.this.jmsMessageBus.getProducer().send(jmsMessage);
				}

			} catch (final ParserConfigurationException | SAXException
					| IOException | XmlException | XMPPException
					| URISyntaxException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void subscribeTo(final String[] sources)
				throws URISyntaxException, XMPPException {
			for (String source : sources) {
				subscribeTo(source);
			}
		}

		private void subscribeTo(String source)
				throws URISyntaxException, XMPPException {
			
			URI uri = new URI(source);
			String id = uri.getUserInfo();
			final LeafNode sourceNode = xmppBus.getNode(id);
			sourceNode.subscribe(jid);
			xmppBus.getNode(id).addItemEventListener(new XmppMessageBusListener());
		}
	}

	private void subscribeToMembership(final String topic) throws XMPPException {
		System.out.println("Subscribing to: " + topic);
		if (null != this.xmppBus) {
			this.xmppBus.getNode(topic)
					.subscribe(this.xmppConnection.getUser());
			this.xmppBus.getNode(topic).addItemEventListener(
					new XmppMessageBusListener());
		}
	}

	private void informAboutMembership(final String topic) throws XMPPException {
		System.out.println("Sending INFORM message...");
		final InformDocument informMessage = this
				.generateInformMembershipMessage(topic);
		final LeafNode receiver = this.xmppBus.getNode(mytopic);
		final SimplePayload payload = new SimplePayload("", "",
				informMessage.toString());
		receiver.send(new PayloadItem<SimplePayload>("", payload));
	}

	private void handleCreateApplicationMessage(final String message)
			throws XmlException, IOException, InterruptedException {
		final CreateDocument createDocument = CreateDocument.Factory
				.parse(message);
		final Create createMessage = createDocument.getCreate();
		final Props prop = createMessage.getPropsArray(0);
		final NodeList children = prop.getDomNode().getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			String command = getTextFromNode(children.item(i), "binary_path");
			if (!command.isEmpty())
				System.out.println(execAdapter.exec(command));
		}
	}

	private XMPPConnection xmppConnection;
	private final MessageBus jmsBus;
	private FrcpController frcp;

	private final PubSubManager xmppBus;
	private ItemEventListener<PayloadItem<SimplePayload>> xmppMessageBusListener;
	private String jid;
	private String mytopic;
	private ExecAdapter execAdapter;
		private XmppController xmppController;

	public InformDocument generateInformMembershipMessage(final String topic) {
		final InformDocument doc = InformDocument.Factory.newInstance();
		final Inform inform = Inform.Factory.newInstance();
		inform.addItype(Itype.STATUS);
		String protocol = "xmpp://";
		String id = this.mytopic + "@localhost";// this.xmppConnection.getUser();
		inform.addSrc(protocol + id);
		inform.addTs("123312");
		final Props prop = inform.addNewProps();
		this.addMembershipToProperty(prop, topic);
		doc.setInform(inform);
		return doc;
	}

	private void addMembershipToProperty(final Props prop, final String topic) {
		final QName membership = new QName(prop.getDomNode().getNamespaceURI(),
				"membership");
		final XmlCursor cursor = prop.newCursor();
		cursor.toFirstContentToken();
		cursor.beginElement(membership);
		cursor.insertAttributeWithValue("type", "string");
		cursor.insertChars(topic);
	}

	private static final Logger log = Logger.getLogger(FrcpListener.class
			.getName());

	public FrcpListener(MessageBus messageBus, XMPPConnection xmppConnection)
			throws JMSException, XMPPException {

		this.jmsBus = messageBus;
		this.startJMSListener();
		
		this.xmppController = new XmppController(xmppConnection);
		
		
		
		
		this.xmppBus = new PubSubManager(xmppConnection);
		
		this.execAdapter = new ExecAdapter();
		

		this.jid = xmppConnection.getUser() + "@" + xmppConnection.getHost();
				

		this.xmppMessageBusListener = new XmppMessageBusListener();
		
		System.out.println("Connection User: " + xmppConnection.getUser());
		this.mytopic = RESOURCE_TOPIC;
		LeafNode topicNode = xmppController.getAndSubscribeTopic(mytopic);
		topicNode.addItemEventListener(this.xmppMessageBusListener);
		topicNode
				.addItemEventListener(new ItemEventListener<PayloadItem<SimplePayload>>() {
					public void handlePublishedItems(
							ItemPublishEvent<PayloadItem<SimplePayload>> items) {
						System.out.println("Receiving: ");
						for (PayloadItem<SimplePayload> item : items.getItems()) {
							System.out.println(item.toString());
						}
					}
				});

		this.frcp = new FrcpController("xmpp://", RESOURCE_TOPIC,
				xmppConnection.getHost());
	}

	public void close() {
		if (null != this.xmppConnection) {
			this.xmppConnection.disconnect();
		}
		if (null != this.jmsBus) {
			try {
				this.jmsBus.close();
			} catch (final JMSException e) {
				FrcpListener.log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	private void startJMSListener() throws JMSException {
		this.jmsBus.getConsumer().setMessageListener(
				new FrcpListener.JmsMessageBusListener());
	}

}
