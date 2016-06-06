/**
 * 
 */
package fr.pizzeria.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Controller

@RequestMapping("/pizzas")

public class PizzaController {

	@Autowired
	@Qualifier("springPizzaDaoJpa")
	IPizzaDao pizzaDao;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@Secured("ADMIN")
	public ModelAndView  listePizza() throws DaoException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ListPizza");
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		modelAndView.addObject("pizzas",pizzas);
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Pizza save(@RequestBody Pizza pizza) throws DaoException {
		pizzaDao.savePizza(pizza);
		return pizza;
	}
}