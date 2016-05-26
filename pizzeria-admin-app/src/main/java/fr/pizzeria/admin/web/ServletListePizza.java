/**
 * 
 */
package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
 @WebServlet("/api/servlet/pizzas")
public class ServletListePizza extends HttpServlet {

	private IPizzaDao pizzaDao =new PizzaDaoImpl();
	Logger LOG= Logger.getLogger(ServletListePizza.class.toString());
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
		List<Pizza> listePizzas = pizzaDao.findAllPizzas();
		resp.getWriter().write(listePizzas.toString());
	} catch (DaoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code=req.getParameter("code");
		String nom=req.getParameter("nom");
		String cat=req.getParameter("cat");
		String prix= req.getParameter("prix");
		
		BigDecimal prixRecup=new BigDecimal(prix);
		CategoriePizza categorie=CategoriePizza.valueOf(cat);
		Pizza pizzaRecup=new Pizza(null, code, nom, prixRecup,categorie);
		LOG.info("j'ai bien reçu le code");
	}

	
	
}
