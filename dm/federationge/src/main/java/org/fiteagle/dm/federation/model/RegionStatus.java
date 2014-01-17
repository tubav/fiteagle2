package org.fiteagle.dm.federation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Entity
public class RegionStatus extends LinkableEntity{

	@Id
	long region;
	
	
	long timestamp;
	
	String status;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRegion() {
		return region;
	}
	


	public void setRegion(long id) {
		this.region = id;
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
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this.getClass().equals(obj.getClass())){
			RegionStatus toCompare = (RegionStatus) obj;
			if(this.region == toCompare.getRegion() && this.getStatus().equals(toCompare.getStatus()) && this.getTimestamp() == toCompare.getTimestamp()){
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public void addLinksWithId(String uriInfo) {
		
	}

	@Override
	public void addLinksWithoutId(String uriInfo) {
		String trimmedUri = trimURI(uriInfo);
		this.addLink("self",  new LinkInfo(trimmedUri));
		this.addLink("parent", new LinkInfo(trimmedUri.subSequence(0, trimmedUri.lastIndexOf("/")).toString()));
		
	}
}
