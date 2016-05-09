package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.MettreAJourPizzas;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class Menu {

	private static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	private Map<Integer,AbstractOptionMenu> options;
	private Scanner sc;

	public Menu(Scanner sc,IPizzaDao pizzaDao) {
		super();
		this.sc=sc;
		initialiserOptions(sc, pizzaDao);
	}

	private void initialiserOptions(Scanner scanner, IPizzaDao pizzaDao) {
		options = new TreeMap< Integer,AbstractOptionMenu> ();
		{ 
			options.put(1, new ListerPizzaOptionMenu(pizzaDao));
			options.put(2,new MettreAJourPizzas(pizzaDao,scanner));
			options.put(3,new AjoutPizza(pizzaDao,scanner));
			options.put(4,new SuppressionPizza(pizzaDao,scanner));
			options.put(99,new QuitterOptionMenu());
		};
	}				

	public void afficher() {
		boolean continuer = true;
		while(continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");

			Set<Entry<Integer, AbstractOptionMenu>> entrySet = options.entrySet();

			for (Entry<Integer, AbstractOptionMenu> entry : entrySet) {
				System.out.println(entry.getKey()+ ". " + entry.getValue().getLibelle());
			}

			int saisie = sc.nextInt();
			try {
				continuer = options.get(saisie).execute();
			} catch (UpdatePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
