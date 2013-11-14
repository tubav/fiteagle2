package org.fiteagle.dm.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.fiteagle.boundary.MessageBus;
import org.fiteagle.boundary.MessageBusApplicationServerFactory;

@Path("/configuration/")
public class ConfigurationRest {

	private static final Logger LOGGER = Logger
			.getLogger(ConfigurationRest.class.getName());

	private final Session session;
	private final MessageProducer producer;

	private MessageBus messagebus;
	
	public ConfigurationRest() throws NamingException, JMSException {
		ConfigurationRest.LOGGER.log(Level.INFO,
				"Starting FITeagle REST Interface...");
		this.messagebus = MessageBusApplicationServerFactory
				.createMessageBus();

		this.session = messagebus.getSession();
		this.producer = this.session
				.createProducer(messagebus.getDestination());
	}

	public ConfigurationRest(final javax.jms.Session session,
			final MessageProducer producer) {
		this.session = session;
		this.producer = producer;
	}

	@GET
	@Path("/json/{name}")
	@Produces("application/json")
	public String getValue(@PathParam("name") final String message)
			throws JMSException {
		ConfigurationRest.LOGGER.log(Level.INFO, "Received : " + message);
		final TemporaryQueue responseDestination = this.session
				.createTemporaryQueue();
		final MessageConsumer responseConsumer = this.session
				.createConsumer(responseDestination);
		final TextMessage textMessage = this.session.createTextMessage(message);
		textMessage.setJMSReplyTo(responseDestination);

		this.producer.send(textMessage);

		String responseText = "";
		final TextMessage response = (TextMessage) responseConsumer
				.receive(1000);
		if (null != response) {
			responseText = response.getText();
		}

		this.session.close();
		return responseText;
	}
}
