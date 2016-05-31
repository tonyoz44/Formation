package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class RestAuthFilter implements ContainerRequestFilter {

	@Inject private TokenService tokenservice;
	@Override
	public void filter(ContainerRequestContext arg0) throws IOException {
		String token = arg0.getHeaderString("auth");

		if(!tokenservice.isTokenValid(token)&& arg0.getUriInfo().getPath().contains("/login"))
			{
	
				//non authentifié
				arg0.abortWith(Response.status(Status.FORBIDDEN).build());
			}

	}

}
