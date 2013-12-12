package org.fiteagle.dm.federationge;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistryTest {

	private Registry registry;
	String input = "test";
	String version = "v1";
	String regionid = "1";
	String serviceid = "1";
	
	@Before
	public void setup() {
		this.registry = new Registry();
	}
	
	@Test
	public void testEchoMessageJSON() {
		
		String output = this.registry.handleMessageJSON(regionid, serviceid);
		Assert.assertTrue(output.startsWith("{"));
		Assert.assertTrue(output.contains(serviceid));
	}

	@Test
	public void testEchoMessageXML() {
		
		String output = this.registry.handleMessageXML(regionid, serviceid);
		Assert.assertTrue(output.startsWith("<xml"));
		Assert.assertTrue(output.contains(serviceid));
	}

}
