package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaDaoImpl implements IPizzaDao {
	

	private List<Pizza> pizzas = new ArrayList<Pizza>();
	

	
	

	public PizzaDaoImpl() {
		pizzas.add(new Pizza(null,"PEP", "Peperoni",BigDecimal.valueOf(12.50),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"MAR", "Margherita",BigDecimal.valueOf( 14.00),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"REI", "La Reine", BigDecimal.valueOf(11.50),CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(null,"FRO", "La 4 fromages",BigDecimal.valueOf( 12.00),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"CAN", "La cannibale",BigDecimal.valueOf( 12.50),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"SAV", "La savoyarde",BigDecimal.valueOf( 13.00),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"ORI", "L'orientale",BigDecimal.valueOf( 13.50),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"IND", "L'indienne",BigDecimal.valueOf( 14.00),CategoriePizza.VIANDE));
		pizzas.add(new Pizza(null,"SAU", "Saumon",BigDecimal.valueOf( 14.00),CategoriePizza.POISSON));
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
		
//		while(!placeTrouve && index <pizzas.size())
//		{
//			placeTrouve=pizzas.get(index)!=null;
//			
//			index++;
//		}
//		
		
		//
		Predicate<Pizza> testValeur=  val ->val!= null;
		index =(int)pizzas.stream().filter(testValeur).count();
		pizzas.add(newPizza);
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) {
		
		int index=0;
		boolean test=false;
//		for (Pizza pizza : pizzas) {
//			
//			if(pizza.getCode().equals(codePizza) && pizza!=null)
//			{
//				pizzas.set(index, updatePizza);
//				test=true;
//			}
//			index++;	
//		}
		
		Function<Pizza,Pizza> test1 =  pizzaCherche -> pizzaCherche.getCode().equals(codePizza)?updatePizza:pizzaCherche;
		pizzas=pizzas.stream().map(test1).collect(Collectors.toList());
		
		
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


	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
