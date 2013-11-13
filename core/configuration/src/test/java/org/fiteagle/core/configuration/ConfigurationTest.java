package org.fiteagle.core.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fiteagle.boundary.MessageBus;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testConfiguration() throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"vm://localhost?broker.persistent=false");

		MessageBus messageBus = new MessageBus(factory);

		new Configuration(messageBus);
	}

}
