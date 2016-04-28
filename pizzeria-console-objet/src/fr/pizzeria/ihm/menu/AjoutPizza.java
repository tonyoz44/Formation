package fr.pizzeria.ihm.menu;

import java.sql.Savepoint;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.model.Pizza;

public class AjoutPizza extends AbstractOptionMenu {

	private Scanner sc;


	public AjoutPizza(IPizzaDao pizzaDao,Scanner sc) 
		{
			super("Ajout d'une pizza", pizzaDao);
			this.sc=sc;
		}	
	
	
	@Override
	public boolean execute() {
	
		boolean resultat=false;
		Pizza pizzaNew=new Pizza();
		System.out.println("Donner le code de votre nouvelle pizza");
		String code=sc.next();
		System.out.println("Informer de son  nom");
		String nom=sc.next();
		System.out.println("Informer de son  prix");
		double prix=sc.nextDouble();
		pizzaNew.setCode(code);
		pizzaNew.setNom(nom);
		pizzaNew.setPrix(prix);
		resultat= pizzaDao.savePizza(pizzaNew);
		
		return resultat;
	}

}
