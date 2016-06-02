/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Repository
public class BatchOizzaDaoJdbcTemplate {
	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BatchOizzaDaoJdbcTemplate(DataSource datasource) {

	this.jdbcTemplate = new JdbcTemplate(datasource);

	}	
@Transactional(propagation=Propagation.REQUIRES_NEW)
 public void insertListerPizzas(List<List<Pizza>> listPartitionnee) throws Exception  {

	String sql="INSERT INTO PIZZA(categorie,code_pizza,nom,prix,url_image) values(?,?,?,?,?) ";
			for (List<Pizza> list : listPartitionnee) {
				
				for (Pizza p : list) {
					try {
						//savePizza(p);
						this.jdbcTemplate.update(sql,p.getCategorie(),p.getCode(),p.getNom(),p.getPrix(),p.getUrl_image());
						if(p.getCode().equals("res"))
						{
							throw new Exception();
						}
					} catch (DaoException e) {
						e.printStackTrace();
					}
				}
				
			}

	}

}
