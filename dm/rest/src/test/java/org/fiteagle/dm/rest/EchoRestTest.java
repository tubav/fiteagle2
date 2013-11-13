package org.fiteagle.dm.rest;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EchoRestTest {
	@Test
	public void testWebSockets() {
		final EchoRest ws = new EchoRest();
		final String testMessage = "test";
		String actual;

		actual = ws.echoMessageXML(testMessage);
		Assert.assertTrue(actual.contains(testMessage));

		actual = ws.echoMessageJSON(testMessage);
		Assert.assertTrue(actual.contains(testMessage));
	}
}
