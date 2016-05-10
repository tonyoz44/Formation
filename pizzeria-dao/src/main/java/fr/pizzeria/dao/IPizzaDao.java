package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao  {
	
	List<Pizza> findAllPizzas() throws DaoException;
	boolean savePizza(Pizza newPizza)throws DaoException;
	boolean updatePizza(String codePizza, Pizza updatePizza)throws DaoException;
	boolean deletePizza(String codePizza)throws DaoException;
	
}
