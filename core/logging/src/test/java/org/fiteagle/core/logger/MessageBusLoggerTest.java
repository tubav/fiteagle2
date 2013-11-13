package org.fiteagle.core.logger;

import java.io.FileNotFoundException;


import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
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
		this.messageBus = new MessageBusLocal();
		this.waitingMessageBus = new MessageBusLocal();		
	}

	@After
	public void teardown() throws JMSException {
		this.messageBus.close();
	}

	@Test
	public void testMessageBusLogger() throws JMSException,
			InterruptedException, FileNotFoundException, NamingException {

		final MessageBusLogger mbLogger = new MessageBusLogger(this.messageBus);

		Assert.assertNotEquals("test", mbLogger.getLastTextMessage());
		final TextMessage textMessage = this.messageBus.getSession().createTextMessage("test");
		textMessage.setBooleanProperty("test", true);
		this.messageBus.getProducer().send(textMessage);
		this.waitingMessageBus.getConsumer().receive(50);
		Assert.assertEquals("test", mbLogger.getLastTextMessage());
	}
}
