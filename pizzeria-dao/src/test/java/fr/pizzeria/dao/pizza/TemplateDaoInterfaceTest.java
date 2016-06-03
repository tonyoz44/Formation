/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.ConfigPizzaDaoSpringTest;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = ConfigPizzaDaoSpringTest.class)
public class TemplateDaoInterfaceTest {

	protected IPizzaDao pizzaDao;

	@Test
	public void testFindAllPizzas() throws DaoException {

		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		System.out.println("e");

		Assert.assertEquals(3, pizzas.size());

	}

	@Test
	public void testSaveAllPizzas() throws DaoException {
		List<Pizza> pizzas = new ArrayList<Pizza>();

		pizzas.add(new Pizza(null, "PEP", "Peperoni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "MAR", "Margherita", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(null, "FRO", "La 4 fromages", BigDecimal.valueOf(12.00), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null, "SAU", "Saumon", BigDecimal.valueOf(14.00), CategoriePizza.POISSON));
		pizzaDao.saveAllPizzas(pizzas, 4);
		Assert.assertEquals(12, pizzaDao.findAllPizzas().size());
	}

	@Test
	public void testSave() throws DaoException {
		Pizza pizzas;

		pizzas = new Pizza(null, "PAP", "Peperoni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);

		pizzaDao.savePizza(pizzas);

		Assert.assertEquals(13, pizzaDao.findAllPizzas().size());
	}

}
