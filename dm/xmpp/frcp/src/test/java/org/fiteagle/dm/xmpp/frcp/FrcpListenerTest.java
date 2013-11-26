package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.InformDocument;

import org.apache.xmlbeans.XmlException;
import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FrcpListenerTest implements MessageListener {

	private static final String SERVER = "localhost";
	private static final String USER = "fiteagle";
	private static final String PWD = "test";
	private MessageBus messagebus;
	private XMPPConnection xmppConnection;
	private XmppController xmppController;
	private FrcpController frcpController;

	private static final Logger LOGGER = Logger
			.getLogger(FrcpListenerTest.class.getName());

	private XMPPConnection getMockedConnection() throws XMPPException {
		return XmppController.connect(SERVER, 5222, USER, PWD);
	}

	@Before
	public void setup() throws JMSException, XMPPException, NamingException {
		this.xmppConnection = this.getMockedConnection();
		this.xmppController = new XmppController(xmppConnection);
		this.messagebus = new MessageBusLocal();
		this.frcpController = new FrcpController("xmpp://", "test1", SERVER);

		String filter = MessageBus.getFilter("test1",
				FrcpXmppParser.FRCPMessageType.REQUEST.toString(),
				FrcpXmppParser.FRCPMessageType.NAMESPACE.toString());
		MessageConsumer jmsNode = messagebus.getConsumer(filter);
		jmsNode.setMessageListener(this);
	}


	@Test
	@Ignore
	public void test() throws JMSException, XMPPException,
			InterruptedException, NamingException {

		XmppListener listener = new XmppListener(this.messagebus,
				this.xmppConnection);

		// todo add via jms
		String[] resources = { "test1" };
		for (String resource : resources) {
			listener.getAndSubscribeTopic(resource);
		}

		// while (true)
		// Thread.sleep(1000);
	}

	@Override
	public void onMessage(Message message) {
		LeafNode topic;
		try {
			String requestXml = ((TextMessage) message).getText();
			InformDocument result = (InformDocument) this.frcpController
					.handle(requestXml);

			String resultXml = result.toString();
			topic = this.xmppController.getTopic(message
					.getStringProperty("uid"));
			XmppController.sendTextMessage2(topic, resultXml);
		} catch (XMPPException | JMSException | ParserConfigurationException
				| SAXException | IOException | XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
