package org.fiteagle.dm.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/echo/")
public class EchoRest {
	private static final Logger log = Logger.getLogger(EchoRest.class
			.getName());
	
	
    @GET
    @Path("/json/{name}")
    @Produces("application/json")
    public String echoMessageJSON(@PathParam("name") String name) {
        log.log(Level.INFO, "getting JSON: " + name);
        return "{\"result\":\"" + createHelloMessage(name) + "\"}";
    }

    @GET
    @Path("/xml/{name}")
    @Produces("application/xml")
    public String echoMessageXML(@PathParam("name") String name) {
    	log.log(Level.INFO, "getting XML: " + name);
        return "<xml><result>" + createHelloMessage(name) + "</result></xml>";
    }

	private String createHelloMessage(String name) {
		return name;
	}
	
}
