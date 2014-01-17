package org.fiteagle.dm.federation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;


//@XmlRootElement
@Entity
public class Region extends LinkableEntity{
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	long id;
	String country;
	String latitude;
	String longitude;
	String adminUsername;
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	RegionStatus regionStatus;
	String nodeType;

	@Transient
	Map<String, List<LinkInfo>> _links;
	
	public Map<String,List<LinkInfo>> get_links() {
		return _links;
	}
	
	public void set_links(Map<String, List<LinkInfo>> links) {
		this._links = links;
	}
	
	public void addLink(String name,LinkInfo l){
		List<LinkInfo> list;
		if(this._links == null){
			_links = new HashMap<>();
			list = new ArrayList<>();
			list.add(l);
		}else{
			list = _links.get(name);
			if(list == null)
				list = new ArrayList<>();
			list.add(l);
		}
		_links.put(name,list);
	}
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="region_id", referencedColumnName="ID")
	private List<ContactInformation> contacts;
	

	@XmlTransient
	public List<ContactInformation> getContacts() {
		return contacts;
	}


	public void setContacts(List<ContactInformation> contacts) {
		this.contacts = contacts;
	}


	public long getId() {
		return id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getAdminUsername() {
		return adminUsername;
	}


	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}


	@XmlTransient
	public RegionStatus getRegionStatus() {
		return regionStatus;
	}


	public void setRegionStatus(RegionStatus registrationStatus) {
		
		this.regionStatus = registrationStatus;
	}


	public String getNodeType() {
		return nodeType;
	}


	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}


	public void setId(long id) {
		this.id = id;
		if(null!= regionStatus){
			regionStatus.setRegion(id);
		}
	}

	public void addContact(ContactInformation contactInfo) {
		if(this.contacts == null)
			contacts = new ArrayList<>();
			
		contacts.add(contactInfo);
		
	}

	@Override
	public void addLinksWithId(String uriInfo) {
		this.addLink("self",  new LinkInfo(trimURI(uriInfo)+ "/" + this.getId()));
		this.addLink("status" , new LinkInfo(trimURI(uriInfo)+ "/" + this.getId()+"/status/"));
		if(this.getContacts() != null && this.getContacts().size() > 0){
			for(ContactInformation contactInformation : this.getContacts()){
				this.addLink("contacts",  new LinkInfo(trimURI(uriInfo)+ "/" + this.getId()+"/contacts/" + contactInformation.getId()));
			}
		}
		
	}

	@Override
	public void addLinksWithoutId(String uriInfo) {
		this.addLink("self",  new LinkInfo(trimURI(uriInfo)));
		this.addLink("status" , new LinkInfo(trimURI(uriInfo)+"/status/"));
		if(this.getContacts() != null && this.getContacts().size() > 0){
			for(ContactInformation contactInformation : this.getContacts()){
				this.addLink("contacts",  new LinkInfo(trimURI(uriInfo) + "/contacts/" + contactInformation.getId()));
			}
		}
		
	}
	
	

}
