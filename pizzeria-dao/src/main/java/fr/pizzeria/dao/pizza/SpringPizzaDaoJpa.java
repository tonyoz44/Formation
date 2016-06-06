/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Repository
public class SpringPizzaDaoJpa implements IPizzaDao {
	

	 
	@PersistenceContext private EntityManager em;
	
	@Autowired private BatchPizzaDaoJpaSpring batchPizzaDaoJpaSpring;
	
	@Override  
@Transactional
	public List<Pizza> findAllPizzas() throws DaoException {                                      
	                                     
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> results=query.getResultList();                                                                             
		return results;                                                                        
	}                                                                                             
	                                                                                              
	

	@Override
@Transactional
	public boolean savePizza(Pizza newPizza) throws DaoException {
	

		em.persist(newPizza);


		return true;
	}

	@Override

	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
	
		try{

		TypedQuery<Pizza> namedQuery = em.createNamedQuery("pizza.findPizza", Pizza.class).setParameter("code", codePizza);
		Pizza singleResult = namedQuery.getSingleResult();
		singleResult.setCode(updatePizza.getCode());
		singleResult.setCategorie(updatePizza.getCategorie());
		singleResult.setNom(updatePizza.getNom());
		singleResult.setPrix(updatePizza.getPrix());

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
	

		return true;
	}
	@Override
	@Transactional
 	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
 		ListUtils.partition(listPizzas, nb).forEach(batchPizzaDaoJpaSpring::save);
 	}
	
	
	
	
}
