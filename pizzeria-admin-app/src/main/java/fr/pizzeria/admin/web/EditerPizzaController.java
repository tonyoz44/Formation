/**
 * 
 */
package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {

	IPizzaDao pizzaDao=IPizzaDao.pizzadao;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");
		List<Pizza> allPizzas=null;
		Pizza pizza = null;
		req.setAttribute("code", code);

		try {
			allPizzas = pizzaDao.findAllPizzas();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Optional<Pizza> firstPizza = allPizzas.stream().filter(p->p.getCode().equals(code)).findFirst();
		if(firstPizza.isPresent() )
		{
			 pizza = firstPizza.get();
			req.setAttribute("pizza", pizza);
		}
	
		RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nom=req.getParameter("nom");
		BigDecimal prix=new BigDecimal(req.getParameter("prix"));
		String cat=req.getParameter("categorie");
		CategoriePizza categorie=CategoriePizza.valueOf(req.getParameter("categorie"));
		String code=req.getParameter("code");
		Pizza updatePizza=new Pizza(null,  code,  nom, prix, categorie);
		
		try {
			pizzaDao.updatePizza(code, updatePizza);
			resp.sendRedirect("list");
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
