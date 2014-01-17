package org.fiteagle.dm.federation.model;


public abstract class LinkableEntity {


	public abstract void addLinksWithId(String uriInfo);

	public abstract void addLinksWithoutId(String uriInfo);

	protected String trimURI(String uri) {

		if (uri.lastIndexOf("/") == uri.length() - 1) {
			uri = uri.subSequence(0, uri.length() - 1).toString();
		}
		return uri;
	}
}
