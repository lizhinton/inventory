package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.inventory;

public class inventoryHelper {
	//variables
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("inventory");
	
	//methods
	public void insertItem(inventory i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public inventory searchForItemById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		inventory found = em.find(inventory.class, id);
		em.close();
		return found;
	}
	
	public void editItem(inventory toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(inventory toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<inventory> typedQuery = em.createQuery("select i from inventory i where i.id = :selectedId", inventory.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		inventory result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
}
