package org.fiteagle.dm.xmpp.chat.servlet;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.junit.Ignore;
import org.junit.Test;

public class ChatServletTest {

	@Test
	@Ignore
	public void test() throws XMPPException, JMSException, NamingException,
			InterruptedException {

		final ConnectionConfiguration config = new ConnectionConfiguration(
				"localhost", 5222, "fiteagle_chat");
		final XMPPConnection xmppConnection = new XMPPConnection(config);
		xmppConnection.connect();
		xmppConnection.login("logger", "test", "chat_server");

		/*
		final MessageBus messageBus = new MessageBus(
				new ActiveMQConnectionFactory(
						"vm://localhost?broker.persistent=false"));
		
		new ChatListener(messageBus, xmppConnection);
		while (true) {
			Thread.sleep(1000);
		}
		*/
	}

}
