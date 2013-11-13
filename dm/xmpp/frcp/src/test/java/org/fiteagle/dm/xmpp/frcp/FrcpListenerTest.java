package org.fiteagle.dm.xmpp.frcp;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fiteagle.boundary.MessageBus;
import org.jivesoftware.smack.XMPPException;
import org.junit.Ignore;
import org.junit.Test;

public class FrcpListenerTest {

	private ConnectionFactory factory = new ActiveMQConnectionFactory(
			"vm://localhost?broker.persistent=false");
	private MessageBus mockmessagebus;

	@Test
	@Ignore
	public void test() throws JMSException, XMPPException, InterruptedException {
		this.mockmessagebus = new MessageBus(this.factory);
		new FrcpListener(mockmessagebus);
	}

}
