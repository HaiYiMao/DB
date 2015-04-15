package edu.neu.cs5200.ispot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.ispot.model.AdminUser;
import edu.neu.cs5200.ispot.model.Spot;

public class AdminUserDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("I-Spot");
	EntityManager em = factory.createEntityManager();
	
	public AdminUser createAdminUser(AdminUser info )
	{
		em.getTransaction().begin();
		em.persist(info);
		em.getTransaction().commit();
		return info;
		}
	// readInfoById
	public AdminUser readAdminUserById(Integer id)
	{
		return em.find(AdminUser.class, id);
	}

	// readAllSpots
	public List<AdminUser> readAllAdminUser()
	{
		Query query = em.createQuery("select AdminUser from AdminUser AdminUser");
		return (List<AdminUser>)query.getResultList();
	}
	// updateSpot
	
	
	public AdminUser updateAdminUser(AdminUser info)
	{
		em.getTransaction().begin();
		em.merge(info);
		em.getTransaction().commit();
		return info;
	}

	// deleteSpot
	public void deleteAdminUser(int id) {
		em.getTransaction().begin();
		AdminUser a = em.find(AdminUser.class, id);
		em.remove(a);
		em.getTransaction().commit();
		}

 
	

}


