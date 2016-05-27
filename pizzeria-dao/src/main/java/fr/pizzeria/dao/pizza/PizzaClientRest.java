/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
public class PizzaClientRest implements IPizzaDao {

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080");

		Invocation.Builder builder = target.path("api").path("/rest/pizzas").request();
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#savePizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean savePizza(Pizza newPizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#saveAllPizzas(java.util.List, int)
	 */
	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub

	}

}
