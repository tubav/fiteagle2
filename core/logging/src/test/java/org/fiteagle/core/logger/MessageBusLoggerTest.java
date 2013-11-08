package org.fiteagle.core.logger;

import java.io.FileNotFoundException;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageBusLoggerTest {
	ConnectionFactory factory;
	private MessageBus messageBus;
	private MessageBus waitingMessageBus;

	@Before
	public void setup() throws JMSException {
		this.factory = new ActiveMQConnectionFactory(
				"vm://localhost?broker.persistent=false");
		this.messageBus = new MessageBus("user", "pwd", this.factory, "topic");
		this.waitingMessageBus = new MessageBus("user", "pwd", this.factory,
				"topic");
	}

	@After
	public void teardown() throws JMSException {
		this.messageBus.close();
	}

	@Test
	public void testMessageBusConstructorWithString() throws JMSException {
		new MessageBus("user", "pwd", this.factory, "topic");
	}

	@Test
	public void testMessageBusConstructorWithDestination() throws JMSException {
		final Destination destination = this.factory.createConnection()
				.createSession(false, Session.AUTO_ACKNOWLEDGE)
				.createTopic("topic");
		new MessageBus("user", "pwd", this.factory, destination);
	}

	@Test
	public void testMessageBusLogger() throws JMSException,
			InterruptedException, FileNotFoundException, NamingException {

		final Session session = this.messageBus.getSession();
		final MessageProducer producer = this.messageBus.getProducer();
		final MessageConsumer consumer = this.messageBus.getConsumer();

		final MessageBusLogger mbLogger = new MessageBusLogger(session,
				consumer);

		Assert.assertNotEquals("test", mbLogger.getLastTextMessage());
		producer.send(session.createTextMessage("test"));
		this.waitingMessageBus.getConsumer().receive(50);
		Assert.assertEquals("test", mbLogger.getLastTextMessage());
	}
}
