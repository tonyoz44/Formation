/**
 * 
 */
package fr.pizzeria.console;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.menu.option.MettreAJourPizzas;
import fr.pizzeria.model.CategoriePizza;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
/**
 * @author ETY
 *
 */
public class PizzaAdminAppTest {

	IPizzaDao pizzaDao;
	MettreAJourPizzas ajourPizza;
	@Rule
	public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();

	@Rule
	public final TextFromStandardInputStream systemOutRule =emptyStandardInputStream();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Scanner scanner= new  Scanner(System.in);
		pizzaDao=new PizzaDaoImpl();
		ajourPizza=new MettreAJourPizzas(pizzaDao, scanner);
	}

	@Test
	public void test() throws UpdatePizzaException {
		systemOutRule.provideLines("PEP","newNom","12","0");
		boolean next=ajourPizza.execute();
		assertTrue(next);
	
		
	}

}
