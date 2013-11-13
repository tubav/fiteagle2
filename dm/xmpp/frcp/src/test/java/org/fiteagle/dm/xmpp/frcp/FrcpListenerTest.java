package org.fiteagle.dm.xmpp.frcp;

import javax.jms.JMSException;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.junit.Ignore;
import org.junit.Test;

public class FrcpListenerTest {

	private MessageBus mockmessagebus;
	private XMPPConnection mockedxmppconnection;

	@Test
	@Ignore
	public void test() throws JMSException, XMPPException, InterruptedException {
		this.mockmessagebus = new MessageBusLocal();
		this.mockedxmppconnection = this.getMockedConnection();

		new FrcpListener(this.mockmessagebus, this.mockedxmppconnection);
	}

	private XMPPConnection getMockedConnection() throws XMPPException {
		final ConnectionConfiguration config = new ConnectionConfiguration(
				"fuseco.fokus.fraunhofer.de", 5222, "fiteagle");
		final XMPPConnection xmppConnection = new XMPPConnection(config);
		xmppConnection.connect();
		xmppConnection.login("test", "test", "server");

		// todo: find a way to mock this
		// XMPPConnection mockedConnection =
		// EasyMock.createMock(XMPPConnection.class);
		// EasyMock.replay(mockedConnection);
		// new ServiceDiscoveryManager(mockedConnection);

		return xmppConnection;
	}
}
