package org.fiteagle.dm.rest;

import static org.junit.Assert.*;

import org.fiteagle.dm.rest.EchoRest;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EchoRestTest {
	@Test
	public void testWebSockets() {
		EchoRest ws = new EchoRest();
		final String testMessage = "test";
		String actual;
		
		actual = ws.echoMessageXML(testMessage);
		assertTrue(actual.contains(testMessage));
		
		actual = ws.echoMessageJSON(testMessage);
		assertTrue(actual.contains(testMessage));
	}
}
