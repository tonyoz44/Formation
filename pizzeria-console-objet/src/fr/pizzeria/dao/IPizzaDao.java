package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean savePizza(Pizza newPizza);
	boolean updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException;
	boolean deletePizza(String codePizza);
	
}
