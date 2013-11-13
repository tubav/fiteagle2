package org.fiteagle.core.configuration;

import javax.jms.JMSException;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusLocal;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testConfiguration() throws JMSException {
		final MessageBus messageBus = new MessageBusLocal();

		new Configuration(messageBus);
	}

}
