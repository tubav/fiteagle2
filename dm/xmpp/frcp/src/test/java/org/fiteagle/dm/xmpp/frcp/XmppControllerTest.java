package org.fiteagle.dm.xmpp.frcp;



import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class XmppControllerTest {

	private static final String HOST = "localhost";
	private static final String TOPIC = "test1";
	private static final String PASSWORD = "test";
	private static final String USER = "alex";
	private static final int PORT = 5222;
	private LeafNode topic;

	@Test
	@Ignore
	public void testRunXmppController() throws XMPPException,
			InterruptedException {
		XmppController xmppController = new XmppController(HOST, PORT,
				USER, PASSWORD);
		topic = xmppController.getAndSubscribeTopic(TOPIC);
		ItemEventListener<PayloadItem<SimplePayload>> listener = new TestXmppControllerEventListener();
		topic.addItemEventListener(listener);
		XmppController.sendTextMessage(topic, "test message");
	}
	
	private class TestXmppControllerEventListener implements ItemEventListener<PayloadItem<SimplePayload>> {
		@Override
		public void handlePublishedItems(ItemPublishEvent<PayloadItem<SimplePayload>> event) {
			String topic = event.getNodeId();
			Assert.assertEquals(TOPIC, topic);
			
			for (PayloadItem<SimplePayload> item : event.getItems()) {
				XmppReceiverDetails details = XmppController.getDetails(item);
				System.out.println("Topic: " + topic);
				System.out.println("Namespace: " + details.getNamespace());
				System.out.println("Element: " + details.getElement());
			}
		}		
	}
}
