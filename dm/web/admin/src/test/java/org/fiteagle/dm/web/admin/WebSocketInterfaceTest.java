package org.fiteagle.dm.web.admin;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WebSocketInterfaceTest {
	@Test
	public void testWebSockets() {
		WebSocketInterface ws = new WebSocketInterface();
		final String testMessage = "test";
		assertTrue(testMessage.equals(ws.echoMessage(testMessage)));
	}
}
