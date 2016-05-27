/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Stateless
public class PizzaService {

	@Inject private IPizzaDao pizzaDao;
	 
	@PersistenceContext(unitName="pizzeriaAdmin") private EntityManager em;
	


	public List<Pizza> findAllPizzas() throws DaoException {  
		List<Pizza> listPizza;
		try{
		 listPizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		}
		catch(Exception e)
		{
		throw new DaoException();	
		}
	return listPizza;                                                                               
                                                                      
	}                                                                                             
	                                                                                              
	

	public boolean savePizza(Pizza newPizza) throws DaoException {

		 	try {
		 		em.persist(newPizza);
		 	}
		 	catch(Exception e)
		 	{
		 		throw new DaoException();
		 	}
		


		return true;
	}

	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		Pizza pizza = null;
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

		return true;
	}

	public boolean deletePizza(String codePizza) throws DaoException {
		try{
			Pizza pizza = em.createNamedQuery("pizza.findPizza", Pizza.class).setParameter("code", codePizza).getSingleResult();
			
			em.remove(pizza);
			

		}
		catch(NoResultException e)
		{
			throw new DaoException();
		}

		
		return true;
	}

	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException
	{
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		ListUtils.partition(listPizzas, nb).forEach(list->{em.getTransaction().begin();
		list.forEach(em::persist);
		em.getTransaction().commit();
		});
		em.close();
	}
	
	
}
