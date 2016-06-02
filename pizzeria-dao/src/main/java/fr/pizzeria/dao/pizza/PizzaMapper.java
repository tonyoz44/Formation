/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
public class PizzaMapper implements RowMapper<Pizza> {

	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {

		Pizza p = new Pizza();

		p.setId(rs.getInt("ID"));

		p.setNom(rs.getString("nom"));

		return p;

	}
}