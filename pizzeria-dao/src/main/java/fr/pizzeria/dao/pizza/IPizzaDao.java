package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;


public interface IPizzaDao  {
	
	static IPizzaDao pizzadao=new PizzaDaoImpl();
	List<Pizza> findAllPizzas() throws DaoException;
	boolean savePizza(Pizza newPizza)throws DaoException;
	boolean updatePizza(String codePizza, Pizza updatePizza)throws DaoException;
	boolean deletePizza(String codePizza)throws DaoException;
	void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException;
	
}
