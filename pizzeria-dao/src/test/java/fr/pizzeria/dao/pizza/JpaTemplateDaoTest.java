/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */

public class JpaTemplateDaoTest extends TemplateDaoGenericTest {

@Autowired
public void setPizzaDao(IPizzaDao pizzaDao)
{
	this.pizzaDao=pizzaDao;
}




}
