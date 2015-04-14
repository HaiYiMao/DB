package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.Site;
@Path("/site")
public class SiteDao {

	@GET
	@Path("/world")
	public String sayHello()
	{
		return "HelloWorld!!!!!!!!";
	}
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("HomeWork5");
	EntityManager em = factory.createEntityManager();
	
	//createSite
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Site> createSite(Site s) {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		em.persist(s);  
		em.getTransaction().commit();		
		return findAllSites() ;
	}
	
	//findSite
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") Integer id){
		return em.find(Site.class, id);
	}
	
	//findAllSites
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Site> findAllSites(){
		Query query = em.createQuery("select s from Site s");
	    return (List<Site>)query.getResultList();
	}
	
	//updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id")int siteId, Site s){
		em.getTransaction().begin();
		Site newsite = findSite(siteId); 
		newsite.setName(s.getName());
		newsite.setLatitude(s.getLatitude());
		newsite.setLongitude(s.getLongitude());
		em.merge(newsite);
	    em.getTransaction().commit();
	    return findAllSites();
	
	}

	//removeSite
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	private List<Site> removeSite(@PathParam("id")int id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Site s = em.find(Site.class, id);
		em.remove(s);
		em.getTransaction().commit();
	    return findAllSites();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SiteDao dao = new SiteDao();
		Site s = dao.findSite(4);
//		System.out.println(s.getName());
		s.setName("park");
//		List<Site> sites =dao.createSite(s);
//		System.out.println(sites.getId());
//		Site s = dao.findSite(3);		
//      List<Site> sites = dao.findAllSites();
		List<Site> sites=dao.updateSite(4, s);
        //Site s = new Site(null, "123","345","567");
		
//        List<Site> Sites = dao.createSite(s);
		for(Site si : sites){
    	   System.out.println(si.getName());
      }

	}

}
