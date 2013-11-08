package org.fiteagle.core.logger;

import java.io.FileNotFoundException;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageBusLoggerTest {
	ConnectionFactory factory;
	private MessageBus messageBus;

	@Before
	public void setup() throws JMSException {
		this.factory = new ActiveMQConnectionFactory(
				"vm://localhost?broker.persistent=false");
		this.messageBus = new MessageBus("user", "pwd", factory, "topic");
	}

	@Test
	public void testMessageBusLogger() throws JMSException,
			InterruptedException, FileNotFoundException, NamingException {

		final Session session = messageBus.getSession();
		final MessageProducer producer = messageBus.getProducer();
		final MessageConsumer consumer = messageBus.getConsumer();

		final MessageBusLogger mbLogger = new MessageBusLogger(session,
				consumer, producer);

		Assert.assertNotEquals("test", mbLogger.getLastTextMessage());
		producer.send(session.createTextMessage("test"));
		Thread.sleep(50); // todo: find a better way
		Assert.assertEquals("test", mbLogger.getLastTextMessage());
	}
}
