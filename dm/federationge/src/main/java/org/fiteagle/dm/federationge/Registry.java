package org.fiteagle.dm.federationge;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * FI-PPP Federation GE Implementation.
 * 
 * Test with:
 *   - curl http://localhost:8080/federationge/api/v1/registry/regions/1/services/2.json
 *   - curl http://localhost:8080/federationge/api/v1/registry/regions/1/services/2.xml
 * 
 * @author Alexander Willner <alexander.willner@tu-berlin.de>
 */
@Path("/v1")
public class Registry {
	private static final Logger LOGGER = Logger.getLogger(Registry.class
			.getName());

	//@POST
	//@DELETE
	//@PUT
	//@Consumes(MediaType.APPLICATION_JSON)
	@GET
	@Path("/registry/regions/{regionid}/services/{serviceid}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public String handleMessageJSON(
			@PathParam("regionid") final String regionid,
			@PathParam("serviceid") final String serviceid) {
		Registry.LOGGER.log(Level.INFO, "getting JSON for service " + serviceid);
		return "{\"serviceid\":\"" + this.handleMessage(serviceid) + "\"}";
	}

	//@POST
	//@DELETE
	//@PUT
	//@Consumes(MediaType.APPLICATION_XML)
	@GET
	@Path("/registry/regions/{regionid}/services/{serviceid}.xml")
	@Produces(MediaType.APPLICATION_XML)
	public String handleMessageXML(
			@PathParam("regionid") final String regionid,
			@PathParam("serviceid") final String serviceid) {
		Registry.LOGGER.log(Level.INFO, "getting XML for service " + serviceid);
		return "<xml><serviceid>" + this.handleMessage(serviceid)
				+ "</serviceid></xml>";
	}

	private String handleMessage(final String content) {
		return content;
	}
}
