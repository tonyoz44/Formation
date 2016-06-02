/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
//@Repository
public class JdbcTemplateDao implements IPizzaDao {


	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BatchOizzaDaoJdbcTemplate piz;
	@Autowired
	public JdbcTemplateDao(DataSource datasource) {

	this.jdbcTemplate = new JdbcTemplate(datasource);

	}
	
	
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#savePizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean savePizza(Pizza newPizza) throws DaoException {
		String sql="INSERT INTO PIZZA('categorie,code_pizza,nom,prix,url_image')values (?,?,?,?,?)";
		
		
		return (this.jdbcTemplate.update(sql,newPizza.getCategorie(),newPizza.getCode(),newPizza.getNom(),newPizza.getPrix(),newPizza.getUrl_image())==1);
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		String sql="UPDATE PIZZA SET categorie = ?,code_pizza= ?,nom= ?,prix= ?,url_image= ?  WHERE code_pizza=?";
		return (this.jdbcTemplate.update(sql,updatePizza.getCategorie(),updatePizza.getCode(),updatePizza.getNom(),updatePizza.getPrix(),updatePizza.getUrl_image(),codePizza)==1);
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.pizza.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DaoException {
	String sql="DELETE FROM pizza WHERE code_pizza = ?";
		this.jdbcTemplate.update(sql,codePizza);
		return false;
	}


@Transactional
	public void saveAllPizzas(List<Pizza> listPizzasFichier, int nbGroup) throws DaoException {
	
		
		listPizzasFichier.sort(Comparator.comparing(Pizza::getCode));

		List<List<Pizza>> listPartitionnee = ListUtils.partition(listPizzasFichier, nbGroup);
	
	
			try {
				
				piz.insertListerPizzas(listPartitionnee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}
