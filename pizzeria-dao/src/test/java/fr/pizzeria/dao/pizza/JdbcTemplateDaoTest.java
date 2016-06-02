/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Repository
public class JdbcTemplateDaoTest extends TemplateDaoGenericTest {

@Autowired	
DataSource datasource;


private void retImplDao()
{
	this.pizzaDao=new JdbcTemplateDao(datasource);
}






}
