package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.CreateDocument;
import net.mytestbed.schema.omf.x60.protocol.InformDocument;
import net.mytestbed.schema.omf.x60.protocol.CreateDocument.Create;
import net.mytestbed.schema.omf.x60.protocol.InformDocument.Inform;
import net.mytestbed.schema.omf.x60.protocol.ItypeDocument.Itype;
import net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.fiteagle.dm.xmpp.frcp.FrcpXmppParser.FRCPMessageType;
import org.xml.sax.SAXException;

public class FrcpController {

	private String resourceUID;
	private String server;
	private String protocol;
	private String sourceUID;
	private String pubsub;

	public FrcpController(String protocol, String resourceUID, String sourceUID, String pubsub, String server) {
		this.resourceUID = resourceUID;
		this.sourceUID = sourceUID;
		this.pubsub = pubsub;
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
				final String uidOfResource = this.resourceUID;
				cursor.insertChars(uidOfResource);				
			}
		}
		inform.addSrc(this.protocol + this.resourceUID + "@" + this.server);
		inform.addItype(Itype.STATUS);
		inform.addTs(String.valueOf(System.currentTimeMillis()));
		inform.setMid(UUID.randomUUID().toString());
		inform.addCid(request.getRequest().getMid());
		return result;
	}

	public Object handle(String xml) throws ParserConfigurationException, SAXException, IOException, XmlException {
		FRCPMessageType type = FrcpXmppParser.getType(xml);
		if (type.equals(FRCPMessageType.REQUEST)) {
			RequestDocument request = RequestDocument.Factory.parse(xml);
			return this.handle(request);
		}
		return null;
	}

	public CreateDocument createApplicationRequest(
			String string) {
		CreateDocument createDoc = CreateDocument.Factory.newInstance();
		createDoc.addNewCreate();
		Create create = createDoc.getCreate();
		create.addTs(String.valueOf(System.currentTimeMillis()));
		create.addRtype("application");
		create.addSrc(this.protocol + this.sourceUID);
		Props props = create.addNewProps();
		
		addToProps(props, "binary_path", string);
		addToProps(props, "hrn", string);
		addToProps(props, "membership", this.protocol + this.pubsub);
		addToProps(props, "type", "application");
		
		return createDoc;
	}
	
	public static void addToProps(Props props, String key, String value) {
		final QName type = new QName("http://schema.mytestbed.net/omf/6.0/protocol/application",
				key);
		XmlCursor cursor = props.newCursor();
		cursor.toFirstContentToken();
		cursor.beginElement(type);
		cursor.insertAttributeWithValue("type", "string");
		cursor.insertChars(value);
	}

}
