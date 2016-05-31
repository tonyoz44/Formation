/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author ETY
 *
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1) throws IOException {

		arg1.getHeaders().add("Acces-Control-Allow-Origin", "http://127.0.0.1:8081");
		
	}

}
