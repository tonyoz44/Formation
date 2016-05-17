/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
public class PizzaDaoJpa implements IPizzaDao {
	
	EntityManagerFactory emfactory;
	
	public PizzaDaoJpa(EntityManagerFactory emf) {
		emfactory=emf;
	}

	@Override                                                                                     
	public List<Pizza> findAllPizzas() throws DaoException {                                      
		EntityManager em = emfactory.createEntityManager();                                       
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> results=query.getResultList();
		em.close();                                                                               
		return results;                                                                        
	}                                                                                             
	                                                                                              
	

	@Override
	public boolean savePizza(Pizza newPizza) throws DaoException {
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(newPizza);
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		EntityManager em = emfactory.createEntityManager();
		try{
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		TypedQuery<Pizza> namedQuery = em.createNamedQuery("pizza.findPizza", Pizza.class).setParameter("code", codePizza);
		Pizza singleResult = namedQuery.getSingleResult();
		singleResult.setCode(updatePizza.getCode());
		singleResult.setCategorie(updatePizza.getCategorie());
		singleResult.setNom(updatePizza.getNom());
		singleResult.setPrix(updatePizza.getPrix());
		transaction.commit();
		}
		catch(NoResultException e)
		{
			throw new DaoException();
		}
		finally
		{
			em.close();
		}
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DaoException {
		EntityManager em = emfactory.createEntityManager();
		try{
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();


		transaction.commit();
		}
		catch(NoResultException e)
		{
			throw new DaoException();
		}
		finally
		{
			em.close();
		}
		
		return true;
	}

	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException
	{
		EntityManager em = emfactory.createEntityManager();
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		ListUtils.partition(listPizzas, nb).forEach(list->{em.getTransaction().begin();
		list.forEach(em::persist);
		em.getTransaction().commit();
		});
		em.close();
	}
	
	
}
