package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzas extends AbstractOptionMenu{

	private static final String METTRE_A_JOUR_LES_PIZZAS = "Mettre à jour les pizzas";
	private Scanner sc;

public MettreAJourPizzas(IPizzaDao pizzaDao, Scanner sc)
{
	super(METTRE_A_JOUR_LES_PIZZAS, pizzaDao);
	this.sc=sc;
}


@Override
public boolean execute() {

	System.out.println("Donner le code de la pizza à mettre à jour");
	String code=sc.next();
	System.out.println("Informer de son nouveau nom");
	String nom=sc.next();
	System.out.println("Informer de son nouveau prix");
	double prix=sc.nextDouble();
	Pizza pizzaNew=new Pizza(code,nom,prix);
	boolean reponse =pizzaDao.updatePizza(code,pizzaNew );
	return reponse;
}
	
}
