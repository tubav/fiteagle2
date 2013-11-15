package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform;
import net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype;
import net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.fiteagle.dm.xmpp.frcp.FrcpXmppParser.FRCPMessageType;
import org.xml.sax.SAXException;

public class FrcpController {

	private String username;
	private String server;
	private String protocol;

	public FrcpController(String protocol, String username, String server) {
		this.username = username;
		this.server = server;
		this.protocol = protocol;
	}

	public InformDocument handle(RequestDocument request) {
		List<Property> properties = new FrcpXmppParser().getRequestProperties(request);
		
		InformDocument result = InformDocument.Factory.newInstance();
		Inform inform = result.addNewInform();
		Props props = inform.addNewProps();
		
		for (Property property : properties) {
			if (property.getName().equalsIgnoreCase("uid")) {
				final QName type = new QName(property.getNamespace(),
						property.getName());
				XmlCursor cursor = props.newCursor();
				cursor.toFirstContentToken();
				cursor.beginElement(type);
				cursor.insertAttributeWithValue("type", "string");
				final String uidOfResource = this.username;
				cursor.insertChars(uidOfResource);				
			}
		}
		inform.addSrc(this.protocol + this.username + "@" + this.server);
		inform.addItype(Itype.STATUS);
		inform.addTs(String.valueOf(System.currentTimeMillis()));
		inform.setMid(UUID.randomUUID().toString());
		inform.addCid(request.getRequest().getMid());
		return result;
	}

	public Object handle(String xml) throws ParserConfigurationException, SAXException, IOException, XmlException {
		FRCPMessageType type = new FrcpXmppParser().getType(xml);
		if (type.equals(FRCPMessageType.REQUEST)) {
			RequestDocument request = RequestDocument.Factory.parse(xml);
			return this.handle(request );
		}
		return null;
	}

}
