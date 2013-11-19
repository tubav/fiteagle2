package org.fiteagle.dm.xmpp.chat;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.fiteagle.boundary.MessageBus;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class ChatListener {
	private class JmsMessageBusListener implements MessageListener {
		@Override
		public void onMessage(final Message message) {
			try {
				final TextMessage textMessage = (TextMessage) message;
				final String logMessage = "JMS Received: '"
						+ textMessage.getText() + "'";
				ChatListener.log.log(Level.INFO, logMessage);
				if (null != ChatListener.this.chat)
					ChatListener.this.chat.sendMessage(logMessage);
			} catch (final JMSException | XMPPException e) {
				ChatListener.log.log(Level.SEVERE, e.toString());
			}
		}
	}

	private class XmppMessageBusListener implements ChatManagerListener,
			org.jivesoftware.smack.MessageListener {

		@Override
		public void chatCreated(final Chat arg0, final boolean arg1) {
			ChatListener.this.chat = arg0;
			ChatListener.this.chat
					.addMessageListener(new XmppMessageBusListener());
		}

		@Override
		public void processMessage(final Chat chat,
				final org.jivesoftware.smack.packet.Message incoming) {
			try {
				if (!incoming.getBody().equals("getVersion")) {
					chat.sendMessage("I usually do not answer these questions");
				} else {
					final TemporaryQueue responseDestination = ChatListener.this.jmsMessageBus
							.getSession().createTemporaryQueue();
					final MessageConsumer responseConsumer = ChatListener.this.jmsMessageBus
							.getSession().createConsumer(responseDestination);

					final Message message = ChatListener.this.jmsMessageBus
							.getSession().createTextMessage(incoming.getBody());
					message.setJMSReplyTo(responseDestination);

					ChatListener.this.jmsMessageBus.getProducer().send(message);

					String responseText = "no answer";
					final TextMessage response = (TextMessage) responseConsumer
							.receive(1000);
					if (null != response) {
						responseText = response.getText();
					}

					chat.sendMessage(responseText);
				}
			} catch (XMPPException | JMSException e) {
				ChatListener.log.log(Level.SEVERE, e.toString());
			}

		}
	}

	private XMPPConnection xmppConnection;
	private final MessageBus jmsMessageBus;

	private final ChatManager chatmanager;
	private Chat chat;

	private static final Logger log = Logger.getLogger(ChatListener.class
			.getName());

	public ChatListener(final MessageBus messageBus,
			final XMPPConnection xmppConnection) throws JMSException,
			XMPPException {

		this.jmsMessageBus = messageBus;
		this.startJMSListener();

		this.chatmanager = xmppConnection.getChatManager();
		this.startXmppListener(xmppConnection.getUser());
	}

	public void close() {
		if (null != this.xmppConnection) {
			this.xmppConnection.disconnect();
		}
		if (null != this.jmsMessageBus) {
			try {
				this.jmsMessageBus.close();
			} catch (final JMSException e) {
				ChatListener.log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	private void startJMSListener() throws JMSException {
		this.jmsMessageBus.getConsumer().setMessageListener(
				new ChatListener.JmsMessageBusListener());
	}

	private void startXmppListener(final String topic) throws XMPPException {
		log.log(Level.INFO, "Chatting with: " + topic);
		this.chatmanager.addChatListener(new XmppMessageBusListener());
	}
}
