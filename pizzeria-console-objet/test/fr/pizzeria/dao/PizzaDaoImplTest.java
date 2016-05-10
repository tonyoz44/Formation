package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;



public class PizzaDaoImplTest {

	PizzaDaoImpl implementation;
	@Before
	public void initialisation()
	{
		implementation=new PizzaDaoImpl();
	}
	
	
	@Test
	public void testPizzaDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllPizzas() {
		
		int taille=0;
		taille=implementation.findAllPizzas().size();
		assertEquals(9, taille);
		
	}

	@Test
	public void testSavePizza() {
	int taille=implementation.findAllPizzas().size();
	int taille2=0;
	implementation.savePizza(new Pizza());
	taille2=implementation.findAllPizzas().size();
	assertEquals(10, taille2);
	}

	@Test(expected =UpdatePizzaException.class)
	public void testUpdatePizzaCodeIncorrect() throws UpdatePizzaException {
	
		implementation.updatePizza("NULL", new Pizza());		
	}

	@Test
	public void testUpdatePizzaCodeCorrect() throws UpdatePizzaException {
	
		Pizza test=implementation.findAllPizzas().get(0);
		Pizza test3=implementation.findAllPizzas().get(1);
		implementation.updatePizza("PEP", new Pizza("PEP","peperoni",12.5,CategoriePizza.VIANDE));
		Pizza test2=implementation.findAllPizzas().get(0);
		Pizza test4=implementation.findAllPizzas().get(1);
		assertFalse(test==test2);
		assertTrue(test3==test4);
		
	}
	
	
	
	
	
	@Test
	public void testDeletePizzaExistante() {
		int taille=implementation.findAllPizzas().size();
		int taille2=0;
		List<Pizza> listePizzas=implementation.findAllPizzas();
		implementation.deletePizza("PEP");
		Optional<Pizza> findFirst = listePizzas.stream().filter(p->p.getCode()=="PEP").findFirst();
		assertFalse(findFirst.isPresent());
		taille2=implementation.findAllPizzas().size();
		assertEquals(8, taille2);
	}
		@Test
		public void testDeletePizzaNonExistante() {
			List<Pizza> listePizzas=implementation.findAllPizzas();
			int taille=listePizzas.size();
			int taille2=0;
			boolean test= implementation.deletePizza("POP");
			taille2=listePizzas.size();
			assertFalse(test);	
	}
		

		
}
