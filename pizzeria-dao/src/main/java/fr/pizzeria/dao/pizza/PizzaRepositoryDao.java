/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */

public class PizzaRepositoryDao implements IPizzaDao {

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		// TODO Auto-generated method stub
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
