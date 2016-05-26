/**
 * 
 */
package fr.pizzeria.dao.pizza;

import javax.enterprise.inject.Produces;

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
