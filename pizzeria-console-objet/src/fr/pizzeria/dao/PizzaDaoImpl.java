package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.50,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAU", "Saumon", 14.00,CategoriePizza.POISSON));
	}
	

	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> resultat=new ArrayList<Pizza>(pizzas);

		return resultat;
	}

	@Override
	public boolean savePizza(Pizza newPizza) {
		boolean placeTrouve = false;
		int index=0;
		
		while(!placeTrouve && index <pizzas.size())
		{
			placeTrouve=pizzas.get(index)!=null;
			
			index++;
		}
		pizzas.add(newPizza);
		return placeTrouve;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException{
		
		int index=0;
		boolean test=false;
		for (Pizza pizza : pizzas) {
			
			if(pizza.getCode().equals(codePizza) && pizza!=null)
			{
				pizzas.set(index, updatePizza);
				test=true;
			}
			index++;
		}
		if (test==false)
		{
			throw new UpdatePizzaException();
		}
		return test;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		
		boolean test=false;
		int index=0;
		Iterator<Pizza> iterator = pizzas.iterator();
		while (iterator.hasNext()) {
			Pizza type = (Pizza) iterator.next();
			if(type != null && type.getCode().equals(codePizza)  )
			{
				iterator.remove();
				test=true;
			}


		}
		
		for (Pizza pizza : pizzas) {
			
			if(pizza != null && pizza.getCode().equals(codePizza)  )
			{
				pizzas.remove(pizza);
				test=true;
			}
		}

		
		return 	test;
	}

}
