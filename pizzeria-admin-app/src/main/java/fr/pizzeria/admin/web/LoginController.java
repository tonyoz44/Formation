package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/authentification.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String email="anthony.auzizeau@wanadoo.fr";
		String password="toto";
		if(request.getParameter("password").equals(password)&&request.getParameter("email").equals(email))
		{
			request.getSession().setAttribute("emailUser", email);
			response.sendRedirect(request.getContextPath() +"/pizzas/list");
		}
		else
		{
			response.sendError(400);
			RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/authentification.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
