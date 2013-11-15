package org.fiteagle.dm.xmpp.frcp;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.mytestbed.schema.omf.x60.protocol.PropsDocument.Props;
import net.mytestbed.schema.omf.x60.protocol.RequestDocument;

import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FrcpXmppParser {

	public enum FRCPMessageType {
		CONFIGURE("http://schema.mytestbed.net/omf/6.0/protocol#configure"), REQUEST(
				"http://schema.mytestbed.net/omf/6.0/protocol#request"),
				UNKNOWN("");

		private FRCPMessageType(final String text) {
			this.text = text;
		}

		private final String text;

		@Override
		public String toString() {
			return text;
		}
	}

	public List<Property> getRequestProperties(String xml) throws XmlException {
		RequestDocument request = RequestDocument.Factory.parse(xml);

		return this.getRequestProperties(request);
	}

	public List<Property> getRequestProperties(RequestDocument request) {

		List<Property> properties = new LinkedList<Property>();
		
		for (final Props prop : request.getRequest().getPropsArray()) {
			final NodeList childs = prop.getDomNode().getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				final Node child = childs.item(i);
				final String propertyName = child.getLocalName();
				final String propertyNamespace = child.getNamespaceURI();
				if (null != propertyName && !propertyName.isEmpty())
					properties.add(new Property(propertyNamespace, propertyName));
			}
		}
		return properties;
	}
	public static FRCPMessageType getType(String xml)
			throws ParserConfigurationException, SAXException, IOException, XmlException {
		
		Document doc = loadXMLFromString(xml);
		Property type = getType(doc);

		if (type.toString().equals(FRCPMessageType.REQUEST.toString()))
			return FRCPMessageType.REQUEST;
		if (type.toString().equals(FRCPMessageType.CONFIGURE.toString()))
			return FRCPMessageType.CONFIGURE;

		return FRCPMessageType.UNKNOWN;
	}

	private static Property getType(Document doc) {
		Element element = doc.getDocumentElement();
		String name = element.getNodeName();
		String namespace = element.getNamespaceURI();
		return new Property(namespace, name);
	}

	public static Document loadXMLFromString(String s) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();	
		Document document = builder.parse(new InputSource(new StringReader(s)));
		return document;
	}


}
