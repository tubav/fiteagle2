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

@Path("/configuration/")
public class ConfigurationRest {

	
	private static final Logger LOGGER = Logger
			.getLogger(ConfigurationRest.class.getName());

	private final Session session;
	private final MessageProducer producer;

	public ConfigurationRest() throws NamingException, JMSException {
		LOGGER.log(Level.INFO, "Starting FITeagle WebSocket Interface...");
		MessageBus messagebus = new MessageBus();
		
		this.session = messagebus.getSession();
		this.producer = session.createProducer(messagebus.getDestination());
	}

	public ConfigurationRest(javax.jms.Session session,
			MessageProducer producer) {
		this.session = session;
		this.producer = producer;
	}

    @GET
    @Path("/json/{name}")
    @Produces("application/json")
	public String getValue(@PathParam("name") String message) throws JMSException {
		LOGGER.log(Level.INFO, "Received : " + message);
		TemporaryQueue responseDestination = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session
				.createConsumer(responseDestination);
		final TextMessage textMessage = this.session.createTextMessage(message);
		textMessage.setJMSReplyTo(responseDestination);
		
		this.producer.send(textMessage);
		
		String responseText = "";
		TextMessage response = (TextMessage) responseConsumer.receive(1000);
		if (null != response)
			responseText = response.getText();
		
		return responseText;
	}
}
