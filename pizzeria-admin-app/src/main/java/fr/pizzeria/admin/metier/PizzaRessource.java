/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Path("/rest/pizzas")
public class PizzaRessource {
	@Inject private PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Pizza> findAllPizzas() throws DaoException {
		//ResponseBuilder respBuilder =Response.ok();
		//respBuilder.entity(pizzaService.findAllPizzas());
		return pizzaService.findAllPizzas();
		//respBuilder.header("Acces-Control-Allow-Origin", "http://127.0.0.1:8081");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public boolean savePizza(Pizza newPizza) throws DaoException {
		return pizzaService.savePizza(newPizza);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)

	public boolean updatePizza( Pizza updatePizza) throws DaoException {
		return pizzaService.updatePizza(updatePizza.getCode(), updatePizza);
	}
	
	@DELETE
	@Path("/{code}")
	public boolean deletePizza(@PathParam("code") String deletePizza) throws DaoException {
		pizzaService.deletePizza(deletePizza);
		return true;
	}
	
}
