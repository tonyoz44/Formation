/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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

//	@Override
//	public List<Pizza> findAllPizzas() throws DaoException {
//		EntityManager em = emfactory.createEntityManager();
//		List<Pizza> resultList = em.createNamedQuery("pizza.findAll",Pizza.class).getResultList();
//		em.close();
//		return resultList;
//	}
	@Override                                                                                     
	public List<Pizza> findAllPizzas() throws DaoException {                                      
		EntityManager em = emfactory.createEntityManager();                                       
		TypedQuery<Pizza> query = em.createQuery("select p from pizza p", Pizza.class);
		List<Pizza> results=query.getResultList();
		em.close();                                                                               
		return results;                                                                        
	}                                                                                             
	                                                                                              
	

	@Override
	public boolean savePizza(Pizza newPizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
