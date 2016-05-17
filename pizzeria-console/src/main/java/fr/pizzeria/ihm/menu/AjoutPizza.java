package fr.pizzeria.ihm.menu;

import java.math.BigDecimal;
import java.sql.Savepoint;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.model.CategoriePizza;
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
		BigDecimal prix=sc.nextBigDecimal();
		System.out.println("Informer la categorie de la pizza");
		CategoriePizza[] pizzasCategorie = CategoriePizza.values();
		for (CategoriePizza	 categorie: pizzasCategorie) {
			System.out.println(categorie.ordinal()+"->"+ categorie.getLibelle());
		}
		int valeurSaisi = sc.nextInt();
		
		pizzaNew.setCategorie(pizzasCategorie[valeurSaisi]);
		pizzaNew.setCode(code);
		pizzaNew.setNom(nom);
		pizzaNew.setPrix(prix);
		try {
			resultat= pizzaDao.savePizza(pizzaNew);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}

}
