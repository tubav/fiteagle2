package org.fiteagle.dm.federation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Entity
public class ContactInformation extends LinkableEntity{

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;	
	public long getId() {
		return id;
	}


	String name;
	String country;
	String fax;
	String phone;
	String email;
	String type;
	@ManyToOne
	@XmlTransient
	Region region;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		boolean ret =false;
		if(obj.getClass().equals(this.getClass())){
			ContactInformation toCompare  = (ContactInformation) obj;
			if(this.getAddress().equals(toCompare.getAddress())&&
			   this.getCountry().equals(toCompare.getCountry())&&
			   this.getEmail().equals(toCompare.getEmail())&&
			   this.getFax().equals(toCompare.getFax())&&
			   this.getName().equals(toCompare.getName())&&
			   this.getPhone().equals(toCompare.getPhone())&&
			   this.getType().equals(toCompare.getType())){
				ret = true;
			}
		}
		return ret;
	}
	

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

	@Override
	public void addLinksWithId(String uriInfo) {
		this.addLink("self",  new LinkInfo(trimURI(uriInfo)+ "/" + this.getId()));
		
	}

	@Override
	public void addLinksWithoutId(String uriInfo) {
	
		
	}
	
}
