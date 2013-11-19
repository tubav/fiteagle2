package org.fiteagle.dm.xmpp.frcp;

public class Property {
	private String name;

	public Property(String propertyNamespace, String propertyName) {
		this.namespace = propertyNamespace;
		this.name = propertyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	private String namespace;

}
