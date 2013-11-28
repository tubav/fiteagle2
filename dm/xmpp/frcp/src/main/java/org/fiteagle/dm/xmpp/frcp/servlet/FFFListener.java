package org.fiteagle.dm.xmpp.frcp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import net.mytestbed.schema.omf.x60.protocol.CreateDocument;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBus.Property;
import org.fiteagle.boundary.MessageBus.Status;
import org.fiteagle.boundary.MessageBus.Type;
import org.fiteagle.dm.xmpp.frcp.FrcpController;
import org.fiteagle.dm.xmpp.frcp.FrcpListener;
import org.fiteagle.dm.xmpp.frcp.FrcpListener.XmppMessageBusListener;
import org.fiteagle.dm.xmpp.frcp.XmppController;
import org.fiteagle.dm.xmpp.frcp.XmppController.XmppReceiverDetails;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class FFFListener implements
		ItemEventListener<PayloadItem<SimplePayload>>, MessageListener {

	private final MessageBus jms;
	private final XmppController xmpp;
	private Status status;
	private XMPPConnection xmppBus;
	private FrcpController frcp;
	private LeafNode topic;

	private static final Logger LOGGER = Logger.getLogger(FFFListener.class
			.getName());

	public FFFListener(final MessageBus jmsBus, final XMPPConnection xmppBus)
			throws XMPPException, JMSException {

		this.status = MessageBus.Status.UNKNOWN;

		this.xmppBus = xmppBus;
		this.xmpp = new XmppController(xmppBus);

		

		this.jms = jmsBus;
		this.subscribeToJmsEvent(Type.STATUSQUERY);
		this.subscribeToJmsEvent(Type.INFORM);
	}

	private void subscribeToJmsEvent(final Type type) throws JMSException {
		final String filter = MessageBus.getFilter(type);
		this.jms.getConsumer(filter).setMessageListener(this);
	}

	@Override
	public void handlePublishedItems(
			final ItemPublishEvent<PayloadItem<SimplePayload>> xmppItems) {
		try {
			FrcpListener frcpListener = new FrcpListener(this.jms,
					this.xmpp.getConnection());
			XmppMessageBusListener handler = frcpListener.new XmppMessageBusListener();
			handler.handlePublishedItems(xmppItems);
			for (final PayloadItem<SimplePayload> item : xmppItems.getItems()) {
				final XmppReceiverDetails details = XmppController
						.getDetails(item);
				xmppItems.getNodeId();
				details.getNamespace();
				details.getElement();
				final String message = item.getPayload().toXML();
				LOGGER.log(Level.INFO, " FFF got: " + message);
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
			}
		} catch (final JMSException | XMPPException e) {
			e.printStackTrace();
			FFFListener.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	private void sendStatus() throws JMSException {
		final TextMessage busmessage = this.jms.getSession()
				.createTextMessage();

		busmessage.setStringProperty(MessageBus.Property.TYPE.toString(),
				MessageBus.Type.STATUSNOTIFICATION.toString());
		busmessage.setStringProperty(MessageBus.Property.UID.toString(),
				"Samsung S4");
		busmessage.setText(String.valueOf(this.status));
		this.jms.getProducer().send(busmessage);
	}

	@Override
	public void onMessage(final Message jmsMessage) {
		try {
			String type = jmsMessage
					.getStringProperty(Property.TYPE.toString());
			String uid = jmsMessage.getStringProperty(Property.UID.toString());
			String message = ((TextMessage) jmsMessage).getText();

			if (Type.INFORM.toString().equals(type)) {
				final JSONObject json = new JSONObject(message);
				int bandwidth = json.getInt("bandwidth");
				long seconds = json.getLong("duration");
				String ip = json.getString("ip");
				String resource = json.getString("resource");
				this.topic = this.xmpp.getTopic(resource);
				this.subscribeToXmppTopic();

				this.frcp = new FrcpController("xmpp://", resource,
						this.xmpp.getJid(), this.xmpp.getJid(), xmppBus.getHost());
				
				String commandLine;
				
				commandLine = "epcQoSControl start net_a " + bandwidth
						+ "kbps " + ip;
				
				sendCommand(commandLine);

				Timer timer = new Timer();

				commandLine = "epcQoSControl stop net_a";
				
				timer.schedule(new ShutdownTask(commandLine), seconds * 1000);
			} else if (Type.STATUSQUERY.toString().equals(type)) {
				this.sendStatus();
			}
		} catch (final JMSException | JSONException | XMPPException e) {
			e.printStackTrace();
			FFFListener.LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	private Subscription subscribeToXmppTopic() throws XMPPException {
		this.topic.addItemEventListener(this);
		String subscriber;
		subscriber = this.xmpp.getJid();
		LOGGER.log(Level.INFO, "DEBUG2: subscribing " + subscriber + " (XMPP) to " + topic.getId());
		return this.topic.subscribe(subscriber);
	}

	private class ShutdownTask extends TimerTask {
		private String commandLine;

		public ShutdownTask(String commandLine) {
			this.commandLine = commandLine;
		}

		@Override
		public void run() {
			try {
				sendCommand(commandLine);
			} catch (XMPPException e) {
				e.printStackTrace();
			}
		}
	}

	
	public String sendCommandFake(String string) throws IOException, InterruptedException, XMPPException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(string);
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		String result = "";
		while ((line = b.readLine()) != null) {
		  result += line;
		}
		
		return result;
	}
	
	private void sendCommand(String commandLine) throws XMPPException {
		CreateDocument createDoc = this.frcp.createApplicationRequest(commandLine);
		String frcpMessage = createDoc.xmlText();

		XmppController.sendTextMessage2(this.topic, frcpMessage);
		
		try {
			sendCommandFake(commandLine); // bad work for now
		} catch (IOException | InterruptedException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} 
	}
}
