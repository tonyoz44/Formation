/**
 * 
 */
package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;

/**
 * @author ETY
 *
 */
public class SuppressionPizza extends AbstractOptionMenu {

	private Scanner sc;
	private static final String SUPPRESSION_PIZZA_MENU = "Suppression Pizza";
	public SuppressionPizza(IPizzaDao pizzadao, Scanner sc) {
    super(SUPPRESSION_PIZZA_MENU,pizzadao);
    this.sc=sc;
	}
	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.menu.option.AbstractOptionMenu#execute()
	 */
	@Override
	public boolean execute() {
		
		System.out.println("Donner le code de la pizza à supprimer");
		boolean resultat=  pizzaDao.deletePizza(sc.next());
		
		return resultat;
	}

}
