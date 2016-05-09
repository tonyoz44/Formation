package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzas extends AbstractOptionMenu{

	private static final String METTRE_A_JOUR_LES_PIZZAS = "Mettre à jour les pizzas";
	private Scanner sc;
	CategoriePizza categorie;

public MettreAJourPizzas(IPizzaDao pizzaDao, Scanner sc)
{
	super(METTRE_A_JOUR_LES_PIZZAS, pizzaDao);
	this.sc=sc;
}


@Override
public boolean execute() throws UpdatePizzaException {
//	Pizza pizzaNew;
	System.out.println("Donner le code de la pizza à mettre à jour");
	String code=sc.next();
//	if(pizzaDao.findAllPizzas().contains())
//	pizzaNew.setCode(code);
	System.out.println("Informer de son nouveau nom");
	String nom=sc.next();
	System.out.println("Informer de son nouveau prix");
	double prix=sc.nextDouble();
	
	System.out.println("Informer la catégorie de la pizza");
	CategoriePizza[] pizzasCategorie = CategoriePizza.values();
	for (CategoriePizza	 categorie: pizzasCategorie) {
		System.out.println(categorie.ordinal()+"->"+ categorie.getLibelle());
	}
	int valeurSaisi = sc.nextInt();
	
	
	Pizza pizzaNew=new Pizza(code,nom,prix,pizzasCategorie[valeurSaisi]);
	boolean reponse =pizzaDao.updatePizza(code,pizzaNew );
	return reponse;
}
	
}
