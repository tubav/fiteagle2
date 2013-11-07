package org.fiteagle.core.logger;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

public class MessageBusLoggerTest {
	@Test
	public void testInMemory() throws JMSException, InterruptedException {
		final Session session = this.getMockSession();
		final Destination destination = session.createQueue("TESTQUEUE");
		final MessageProducer producer = session.createProducer(destination);
		final MessageConsumer consumer = session.createConsumer(destination);

		final MessageBusLogger mbLogger = new MessageBusLogger(session,
				consumer, producer);
		
		Assert.assertNotEquals("test", mbLogger.getLastTextMessage());
		producer.send(session.createTextMessage("test"));
		Thread.sleep(1); // todo: find a better way
		Assert.assertEquals("test", mbLogger.getLastTextMessage());
	}

	private Session getMockSession() throws JMSException {
		Session session;
		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"vm://localhost?broker.persistent=false");
		final Connection connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}
}
