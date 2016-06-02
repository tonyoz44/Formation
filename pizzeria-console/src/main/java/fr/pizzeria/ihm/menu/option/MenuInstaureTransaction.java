/**
 * 
 */
package fr.pizzeria.ihm.menu.option;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.JdbcTemplateDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */

public class MenuInstaureTransaction extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "transaction";
	
	public MenuInstaureTransaction(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}
	
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.menu.option.AbstractOptionMenu#execute()
	 */
	@Override
	public boolean execute() {
		Pizza pizza0= new Pizza(null,"res","lole",new BigDecimal(12),CategoriePizza.POISSON);
		Pizza pizza1= new Pizza(null,"tre","lole",new BigDecimal(12),CategoriePizza.POISSON);
		Pizza pizza2= new Pizza(null,"lou","lole",new BigDecimal(12),CategoriePizza.POISSON);
		Pizza pizza3= new Pizza(null,"rat","lole",new BigDecimal(12),CategoriePizza.POISSON);
		Pizza pizza4= new Pizza(null,"poi","lole",new BigDecimal(12),CategoriePizza.POISSON);
		                             
		List<Pizza> listPizzasFichier=new ArrayList<>();
		listPizzasFichier.add(pizza0);
		listPizzasFichier.add(pizza1);
		listPizzasFichier.add(pizza2);
		listPizzasFichier.add(pizza3);
		listPizzasFichier.add(pizza4);
		try {
			pizzaDao.saveAllPizzas(listPizzasFichier, 2);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
