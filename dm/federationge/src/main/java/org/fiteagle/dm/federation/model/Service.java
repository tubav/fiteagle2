package org.fiteagle.dm.federation.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s"),
	@NamedQuery(name="Service.findByType", query="SELECT s FROM Service s WHERE s.type = :type")
})
public class Service extends LinkableEntity{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	String type;

	@Transient
	Map<String,LinkInfo> _links;

	
	public Map<String, LinkInfo> get_links() {
		return _links;
	}
	
	public void set_links(Map<String, LinkInfo> links) {
		this._links = links;
	}
	
	public void addLink(String name,LinkInfo l){
		if(this._links == null)
			_links = new HashMap<>();
			
		_links.put(name,l);
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long serviceId) {
		this.id = serviceId;
		
	}

	@Override
	public void addLinksWithId(String uriInfo) {
		this.addLink("self",  new LinkInfo(trimURI(uriInfo)+ "/" + this.getId()));
		
	}

	@Override
	public void addLinksWithoutId(String uriInfo) {
		// TODO Auto-generated method stub
		
	}
	
	
}
