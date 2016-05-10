package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {

	private static final String APPLICATION_PROPERTIES = "application.properties";

	public static void main(String[] args) {

		
		ResourceBundle bundle= ResourceBundle.getBundle("application");
		String confString=bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		IPizzaDao dao=null;
		switch (daoImplConf) {
		case 0:
			dao=new PizzaDaoImpl();
			lancerApp(dao);
			break;
		case 1:
			dao=new PizzaDaoFichierImpl();
			lancerApp(dao);
			break;
		default:
			System.err.println("Aucune configuration daoImp trouv�e"); 
			break;
		}	
		lancerApp(dao);
	}

	private static void lancerApp(IPizzaDao dao) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(sc,dao);
		menu.afficher();
	}

}
