package org.fiteagle.core.logger;

import java.io.FileNotFoundException;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fiteagle.boundary.MessageBus;
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
		this.messageBus = new MessageBus(this.factory);
		this.waitingMessageBus = new MessageBus(this.factory);
	}

	@After
	public void teardown() throws JMSException {
		this.messageBus.close();
	}

	@Test
	public void testMessageBusConstructorWithString() throws JMSException {
		new MessageBus(this.factory);
	}

	@Test
	public void testMessageBusConstructorWithDestination() throws JMSException {
		new MessageBus(this.factory);
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
		final TextMessage textMessage = session.createTextMessage("test");
		textMessage.setBooleanProperty("test", true);
		producer.send(textMessage);
		this.waitingMessageBus.getConsumer().receive(50);
		Assert.assertEquals("test", mbLogger.getLastTextMessage());
	}
}
