package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private Pizza[] pizzas = new Pizza[100];

	public PizzaDaoImpl() {
		pizzas[0] = new Pizza("PEP", "Peperoni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REI", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	}
	

	@Override
	public Pizza[] findAllPizzas() {
		Pizza[] resultat = new Pizza[100];
		System.arraycopy(pizzas, 0, resultat, 0, resultat.length);
		return resultat;
	}

	@Override
	public boolean savePizza(Pizza newPizza) {
		boolean placeTrouve = false;
		int index=0;
		
		while(!placeTrouve && index <pizzas.length)
		{
			placeTrouve=pizzas[index]!=null;
			
			index++;
		}
		pizzas[index]=newPizza;
		return placeTrouve;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) {
		
		int index=0;
		boolean test=false;
		for (Pizza pizza : pizzas) {
			index++;
			if(pizza.getCode().equals(codePizza) && pizza!=null)
			{
				pizzas[index]=pizza;
				test=true;
			}
		}
		return test;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		
		boolean test=false;
		int index=0;
		for (Pizza pizza : pizzas) {
			
			if(pizza != null && pizza.getCode().equals(codePizza)  )
			{
				pizzas[index]=null;
				test=true;
			}
		}

		
		return 	test;
	}

}
