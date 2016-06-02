/**
 * 
 */
package fr.pizzeria.console;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.DaoImplFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.JdbcTemplateDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */

public class Main {

	/**
	 * @param args
	 */
	@Inject
	JdbcTemplateDao instJdbc;
	

	
	public static void main(String[] args) throws DaoException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confDao = bundle.getString("dao.impl");
		
		try(AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class))
		{
			//Pizza(String url_image, String code, String nom, BigDecimal prix, CategoriePizza categorie)


			Menu menuPrincipal=context.getBean(Menu.class);
			menuPrincipal.afficher();

		}
	}

}
