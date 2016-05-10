package fr.pizzeria.ihm.menu.option;

import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister Pizzas";

	
	
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister Pizza Menu");
		List<Pizza> pizzas;
		try {
			pizzas = pizzaDao.findAllPizzas();

		
		pizzas.stream().forEach(System.out::println);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for (Pizza p : pizzas) {
//			if(p != null) {
//				System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + ")");
//			}
//		}
		/*
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + ")");
			}
		}
		*/
		return true;
	}

}
