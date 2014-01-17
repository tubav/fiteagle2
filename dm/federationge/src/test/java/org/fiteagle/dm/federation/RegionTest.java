package org.fiteagle.dm.federation;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.openjpa.kernel.DelegatingResultList;
import org.easymock.EasyMock;
import org.fiteagle.dm.federation.model.ContactInformation;
import org.fiteagle.dm.federation.model.Region;
import org.fiteagle.dm.federation.model.RegionStatus;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegionTest {

	
	private RegionResource registry;
	String input = "test";
	String version = "v3";
	static long regionid = 0;
	static String serviceid = "0";
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	private static EJBContainer container;
	
	
	@BeforeClass
	public static void setupClass() throws EJBException, NamingException{
		Properties p = new Properties();
		 p.put("registryDB", "new://Resource?type=DataSource");
	     p.put("registryDB.JdbcDriver", "org.h2.Driver");
	     p.put("registryDB.JdbcUrl", "jdbc:h2:mem:test;INIT=CREATE SCHEMA IF NOT EXISTS  registry;");
		container = EJBContainer.createEJBContainer(p);
	}
	@Before
	public void setup() throws NamingException{
		registry = (RegionResource) container.getContext().lookup("java:global/federationge/RegionResource");
	}
	@AfterClass
	public static void tearDown(){
		container.close();
	}
	@Test
	public void testPostRegionInfo() throws URISyntaxException{
		Region r = createDummyRegion();
		UriInfo uriInfo = createUriInfoMock();
		Response resp = registry.postRegionInfo(uriInfo,r);
		Region created = (Region) resp.getEntity();
		
		System.out.println(created.getId());
		Assert.assertNotNull(created.getId());
		RegionTest.regionid = created.getId();
		Assert.assertNotNull(created.getRegionStatus());
	}
	private UriInfo createUriInfoMock() throws URISyntaxException {
		UriInfo uriInfo = EasyMock.createMock(UriInfo.class);
		EasyMock.expect(uriInfo.getAbsolutePath()).andReturn(new URI("http://localhost:1234/regions"));
		EasyMock.expectLastCall().anyTimes();
		EasyMock.replay(uriInfo);
		return uriInfo;
	}
	private Region createDummyRegion() {
		Region r = new Region();
		r.setAdminUsername("admin");
		r.setCountry("de");
		r.setNodeType("slave");
	
		return r;
	}
	@Test
	public void testGetAllRegions() throws URISyntaxException{
		UriInfo uriInfo = createUriInfoMock();
		Response res =registry.getAllRegions(uriInfo, null, null, null);
		List<Region> regions = (DelegatingResultList<Region> ) res.getEntity();
		
	
		Assert.assertEquals(200, res.getStatus());
		Region r = regions.get(0);
		
	}
	@Test
	public void testGetAllRegionsForCountry() throws URISyntaxException{
		registry.getAllRegions(createUriInfoMock(), "de",null,null);
	}
	@Test
	public void testGetRegionInfo() throws URISyntaxException{
		log.info(regionid+ "");
		UriInfo uriInfo = createUriInfoMock();

		Response r = registry.getRegionInfo(uriInfo, regionid);
		
		Assert.assertNotNull(r);
	} 
	
	@Test
	public void testGetRegionStatus() throws URISyntaxException{
		UriInfo uriInfo = createUriInfoMock();
		Response res = registry.getRegionStatus(uriInfo,regionid);
		RegionStatus status = (RegionStatus) res.getEntity();
		Assert.assertNotNull(status);
	}
	
	
	@Test 
	public void testUpdateRegionInfo() throws URISyntaxException{
		Region r = new Region();
		r.setAdminUsername("admin");
		r.setCountry("de");
		r.setNodeType("slave");
		UriInfo uriInfo = createUriInfoMock();

		registry.updateRegion(uriInfo, regionid,r);
	}
	
	@Test
	public void testUpdateRegionStatus() throws URISyntaxException {
		RegionStatus status = new RegionStatus();
		status.setStatus("active");
		UriInfo uriInfo = createUriInfoMock();
		registry.updateRegionStatus(uriInfo, regionid, status);
		
	}
	
	@Test
	public void testDeleteRegion(){
		registry.deleteRegion(regionid);
	}
	
	@Test
	public void addContactInformation() throws URISyntaxException{
		ContactInformation orgInfo = new ContactInformation();
		orgInfo.setAddress("some");
		orgInfo.setCountry("de");
		orgInfo.setEmail("some");
		orgInfo.setFax("some");
		orgInfo.setName("org");
		orgInfo.setPhone("some");
		orgInfo.setType("organization");
		UriInfo uriInfo = createUriInfoMock();
		Region reg = createDummyRegion();
		reg = (Region) registry.postRegionInfo(uriInfo, reg).getEntity();
		Response res = registry.addContactInformation(uriInfo, reg.getId(), orgInfo);
		Assert.assertNotNull(res);
		Assert.assertEquals(201, res.getStatus());
	}
	
	@Test 
	public void getContacts() throws URISyntaxException{
		UriInfo uriInfo = createUriInfoMock();	
		List<ContactInformation> contacts =  (DelegatingResultList<ContactInformation> ) registry.getRegionContacts(uriInfo, regionid, null).getEntity();
		Assert.assertNotNull(contacts);
	}
	
	@Test
	public void getContactById() throws URISyntaxException {
		UriInfo uriInfo = createUriInfoMock();	
		Response res =  registry.getContactInfo(uriInfo, regionid, 1);
		ContactInformation info  = (ContactInformation)res.getEntity();
		Assert.assertEquals(200,res.getStatus() );
		Assert.assertNotNull(info);
	}
	
	
	@Test
	public void updateContact() throws URISyntaxException {
		UriInfo uriInfo = createUriInfoMock();	
		ContactInformation orgInfo = new ContactInformation();
		orgInfo.setAddress("someNew");
		orgInfo.setPhone("someNew");
		Response res =  registry.updateContactInformation(uriInfo, regionid, 1, orgInfo);
		Assert.assertEquals(201, res.getStatus());
		Assert.assertEquals(ContactInformation.class, res.getEntity().getClass());
	}
	@Test
	public void deleteContact() throws URISyntaxException{
		UriInfo uriInfo = createUriInfoMock();	
		Response res =  registry.deleteContact(uriInfo,regionid, 1);
		Assert.assertEquals(204, res.getStatus());
	}
	
//	@Test
//	public void testCreateService() throws URISyntaxException{
//		Service service = new Service();
//		service.setType("something");
//		UriInfo uriInfo = EasyMock.createMock(UriInfo.class);
//		EasyMock.expect(uriInfo.getAbsolutePath()).andReturn(new URI("http://localhost:1234/services"));
//		EasyMock.replay(uriInfo);
//		Response res =  registry.addService(uriInfo, service);
//		Service created = (Service)res.getEntity();
//		Assert.assertNotNull(created.getId());
//		Assert.assertEquals(201,res.getStatus());
//		Assert.assertEquals("something", created.getType());
//		serviceid = String.valueOf(created.getId());
//		
//	}
	
//	@Test
//	public void testGetServices() throws URISyntaxException{
//		testCreateService();
//		Response res = registry.getAllServices(null, null, null);
//		
//		Assert.assertNotNull(res);
//		Assert.assertEquals(200,res.getStatus());
//		
//	}
//	
//	@Test
//	public void testGetServicesFilteredByType() throws URISyntaxException{
//		testCreateService();
//		Response res = registry.getAllServices("something", null, null);
//		Assert.assertEquals(200,res.getStatus());
//	}
//	
//	@Test
//	public void testGetServiceById() throws URISyntaxException{
//		testCreateService();
//		Response res = registry.getService(serviceid);
//		Service service = (Service) res.getEntity();
//		Assert.assertNotNull(service);
//		Assert.assertEquals("something", service.getType());
//		Assert.assertEquals(200,res.getStatus());
//		
//	}
//	
//	@Test
//	public void testUpdateService() throws URISyntaxException{
//		Service newService = new Service();
//		newService.setType("updated");
//		UriInfo uriInfo = EasyMock.createMock(UriInfo.class);
//		EasyMock.expect(uriInfo.getAbsolutePath()).andReturn(new URI("http://localhost:1234/services/"+serviceid));
//		EasyMock.replay(uriInfo);
//		Response res = registry.updateService(uriInfo,serviceid, newService);
//		Service updated = (Service) res.getEntity();
//		Assert.assertEquals(201, res.getStatus());
//		Assert.assertEquals(serviceid, String.valueOf(updated.getId()));
//		Assert.assertEquals("updated", updated.getType());
//	}
//	
//	@Test
//	public void testDeleteService(){
//		Response res = registry.deleteService(serviceid);
//		Assert.assertEquals(204, res.getStatus());
//		
//	}
}
