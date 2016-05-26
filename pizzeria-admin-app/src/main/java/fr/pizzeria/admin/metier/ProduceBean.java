/**
 * 
 */
package fr.pizzeria.admin.metier;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

/**
 * @author ETY
 * @param <ConfigApp>
 *
 */
public class ProduceBean {

	@Produces
	public IPizzaDao getConfig() {
		return new PizzaDaoImpl();
	}
	
}
