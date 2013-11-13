package org.fiteagle.dm.ws;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EchoWebSocketTest {
	@Test
	public void testWebSockets() {
		final EchoWebSocket ws = new EchoWebSocket();
		final String testMessage = "test";
		final String expected = "testEcho";
		final String actual = ws.echoMessage(testMessage);
		Assert.assertEquals(expected, actual);
	}
}
