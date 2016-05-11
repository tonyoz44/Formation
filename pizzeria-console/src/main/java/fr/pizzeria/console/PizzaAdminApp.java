package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.CommonDataSource;

import org.apache.commons.logging.impl.Log4JLogger;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {
	
	private static final Logger LOG = Logger.getLogger("PizzaAdminApp");

	
	private PizzaAdminApp()
	{
		
	}

	public static void main(String[] args) {
		LOG.log(Level.INFO, "Démarrage de l'application");
		
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
			
			System.err.println("Aucune configuration daoImp trouve"); 
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
