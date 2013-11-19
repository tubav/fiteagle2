package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FrcpControllerTest {
	@Test
	public void testResponseToRequestUidViaXML() throws IOException,
			XmlException, ParserConfigurationException, SAXException {
		
		final String id = "fiteagle";
		final String protocol = "xmpp://";
		final String server = "localhost";
		final String filename = "examples/uid_request.xml";
		
		final String xml = FrcpXmppParserTest.readFile(filename);
		FrcpController controller = new FrcpController(protocol, id, server);
		RequestDocument request = RequestDocument.Factory.parse(xml);
		InformDocument result = (InformDocument) controller.handle(request);
		System.out.println(result.getInform());
		Assert.assertEquals(1, result.getInform().getPropsArray().length);
		Assert.assertEquals(true, result.getInform().getPropsArray(0)
				.getDomNode().hasChildNodes());
		Assert.assertEquals("uid", result.getInform().getPropsArray(0)
				.getDomNode().getFirstChild().getLocalName());
		Assert.assertEquals(protocol + id + "@" + server, result
				.getInform().getSrcArray(0));
		Assert.assertEquals(request.getRequest().getMid(), result.getInform()
				.getCidArray(0));
	}

}
