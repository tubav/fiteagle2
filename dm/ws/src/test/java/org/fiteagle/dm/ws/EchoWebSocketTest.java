package org.fiteagle.dm.ws;

import static org.junit.Assert.*;

import org.fiteagle.dm.ws.EchoWebSocket;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EchoWebSocketTest {
	@Test
	public void testWebSockets() {
		EchoWebSocket ws = new EchoWebSocket();
		final String testMessage = "test";
		final String expected = "testEcho";
		final String actual = ws.echoMessage(testMessage);
		assertEquals(expected, actual);
	}
}
