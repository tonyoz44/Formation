package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter(urlPatterns = { "/*" },description = "filtre")
public class Filter implements javax.servlet.Filter {

	private static final ServletResponse HttpServletRequest = null;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpReponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		Object email = httpRequest.getSession().getAttribute("emailUser");

		if (httpRequest.getRequestURI().contains("/login") || email != null) {
			chain.doFilter(request, response); // continuer normalement
		} else {

			httpReponse.sendRedirect(httpRequest.getContextPath() + "/login"); // je te repousse et te renvoie vers login
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
