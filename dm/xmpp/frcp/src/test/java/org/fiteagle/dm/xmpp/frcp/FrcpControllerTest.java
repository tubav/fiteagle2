package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;

import javax.jms.JMSException;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.CreateDocument;
import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlException;
import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
import org.fiteagle.dm.xmpp.frcp.FrcpListener.XmppMessageBusListener;
import org.fiteagle.dm.xmpp.frcp.FrcpXmppParser.FRCPMessageType;
import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FrcpControllerTest implements
		ItemEventListener<PayloadItem<SimplePayload>> {
	private XmppController xmpp;
	private MessageBus bus;
	private FrcpController frcp;
	private LeafNode topic;

	@Before
	public void setup() throws JMSException, XMPPException {
		String server = "localhost";
		this.bus = new MessageBusLocal();
		this.xmpp = new XmppController(server, 5222, "alex", "test");

		String resourceUID = "testbar";
		String protocol = "xmpp://";
		String sourceUID = xmpp.getJid();
		this.topic = xmpp.getAndSubscribeTopic(resourceUID);
		String pubsub = topic.getId();
		topic.addItemEventListener(this);
		this.frcp = new FrcpController(protocol, resourceUID, sourceUID,
				pubsub, server);
	}

	@Ignore
	@Test
	public void testCreateApplicationProps() throws XMPPException,
			InterruptedException {

		CreateDocument createDoc = frcp
				.createApplicationRequest("touch /tmp/from_fiteagle");
		String frcpMessage = createDoc.xmlText();
		XmppController.sendTextMessage2(topic, frcpMessage);

		while (true)
			Thread.sleep(1000);
	}

	@Ignore
	@Test
	public void testResponseToRequestUidViaXML() throws IOException,
			XmlException, ParserConfigurationException, SAXException {

		final String id = "fiteagle";
		final String protocol = "xmpp://";
		final String server = "localhost";
		final String filename = "examples/uid_request.xml";
		final String sourceUID = "test123";
		final String pubsub = "test321";

		final String xml = FrcpXmppParserTest.readFile(filename);
		FrcpController controller = new FrcpController(protocol, id, sourceUID,
				pubsub, server);
		RequestDocument request = RequestDocument.Factory.parse(xml);
		InformDocument result = (InformDocument) controller.handle(request);
		System.out.println(result.getInform());
		Assert.assertEquals(1, result.getInform().getPropsArray().length);
		Assert.assertEquals(true, result.getInform().getPropsArray(0)
				.getDomNode().hasChildNodes());
		Assert.assertEquals("uid", result.getInform().getPropsArray(0)
				.getDomNode().getFirstChild().getLocalName());
		Assert.assertEquals(protocol + id + "@" + server, result.getInform()
				.getSrcArray(0));
		Assert.assertEquals(request.getRequest().getMid(), result.getInform()
				.getCidArray(0));
	}

	@Override
	public void handlePublishedItems(
			ItemPublishEvent<PayloadItem<SimplePayload>> xmppItems) {
		System.out.println("RECEIVED!");

		try {
			FrcpListener frcpListener = new FrcpListener(this.bus,
					this.xmpp.getConnection());
			XmppMessageBusListener handler = frcpListener.new XmppMessageBusListener();

			
			for (PayloadItem<SimplePayload> item : xmppItems.getItems()) {
				XmppReceiverDetails details = XmppController.getDetails(item);
				String uid = xmppItems.getNodeId();
				String namespace = details.getNamespace();
				String type = details.getElement();
				String message = item.getPayload().toXML();
				
				System.out.println("Message:" + message);
								
				FRCPMessageType frcpType = FrcpXmppParser.getType(message);
				System.out.println("Type: " + frcpType);

				handler.handlePublishedItems(xmppItems);
			}
		} catch (XmlException | ParserConfigurationException | SAXException
				| IOException | JMSException | XMPPException e) {
			e.printStackTrace();
		}
	}
}
