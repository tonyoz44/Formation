/**
 * 
 */
package fr.pizzeria.dao.performance;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.ConfigAspectsPerformance;
import fr.pizzeria.config.ConfigPizzaDaoSpringTest;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigAspectsPerformance.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestPerformance {
	
	@Autowired
	IPerformanceDao performanceDao;
	@Autowired
	IPizzaDao pizzaDao;
	
	@Test
public	void testSave()
	{
		Performance performance;
		performance=new Performance();
		
		performance.setDate(new Date(2016, 5, 8, 5, 4));
		performance.setService("ok");
		performance.setTempsExecution(new Date(2016, 5, 8, 5, 3));

		performanceDao.save(performance);
		
		Assert.assertEquals(1,performanceDao.findAllPerformance().size());
	}
	@Test
	public	void testSavePizza() throws DaoException
	{
		pizzaDao.findAllPizzas();
		
		performanceDao.findAllPerformance();
		
		Assert.assertEquals(1,performanceDao.findAllPerformance().size());
	}
	
	

}
