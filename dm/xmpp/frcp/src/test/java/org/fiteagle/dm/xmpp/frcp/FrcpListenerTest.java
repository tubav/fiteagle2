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

	private static final String SERVER = "fuseco.fokus.fraunhofer.de";
	private static final String USER = "fiteagle";
	private static final String PWD = "fiteaglepwd";
	private static final String PROTOCOL = "xmpp://";
	private MessageBus mockmessagebus;
	private XMPPConnection mockedxmppconnection;

	private XMPPConnection getMockedConnection() throws XMPPException {
		final ConnectionConfiguration config = new ConnectionConfiguration(
				SERVER, 5222, "fiteagleserver");
		final XMPPConnection xmppConnection = new XMPPConnection(config);
		xmppConnection.connect();
		xmppConnection.login(USER, PWD, "serverfiteagle");

		// todo: find a way to mock this
		// XMPPConnection mockedConnection =
		// EasyMock.createMock(XMPPConnection.class);
		// EasyMock.replay(mockedConnection);
		// new ServiceDiscoveryManager(mockedConnection);

		return xmppConnection;
	}

	@Test
	@Ignore
	public void test() throws JMSException, XMPPException, InterruptedException {
		this.mockmessagebus = new MessageBusLocal();
		this.mockedxmppconnection = this.getMockedConnection();

		new FrcpListener(this.mockmessagebus, this.mockedxmppconnection, PROTOCOL, USER, SERVER);
	}
}
