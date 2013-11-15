package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.XmlException;
import org.fiteagle.dm.xmpp.frcp.FrcpXmppParser.FRCPMessageType;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FrcpXmppParserTest {

	@Test
	public void testGetPropertiesFromRequest() throws IOException, XmlException  {
		final String filename = "examples/uid_request.xml";
		final String xml = readFile(filename);
		final FrcpXmppParser parser = new FrcpXmppParser();
		final List<Property> properties = parser.getRequestProperties(xml);
		Assert.assertEquals(1, properties.size());
		Assert.assertEquals("uid", properties.get(0).getName());
	}
	
	@Test
	public void testTypeFromXML() throws IOException, SAXException, ParserConfigurationException, XmlException {
		final String filename = "examples/uid_request.xml";
		final String xml = readFile(filename);
		final FrcpXmppParser parser = new FrcpXmppParser();
		final FRCPMessageType type = parser.getType(xml);
		Assert.assertEquals(FRCPMessageType.REQUEST, type);
	}
	

	static String readFile(String filename) throws IOException {
		Path path = Paths.get(FrcpXmppParserTest.class.getResource("/" + filename).getFile());
		byte[] encoded = Files.readAllBytes(path);
		return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString();
	}
}
