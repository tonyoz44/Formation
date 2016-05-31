/**
 * 
 */
package fr.pizzeria.admin.web;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



/**
 * @author ETY
 *
 */
@Path("/login")
public class LoginResource {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("email") String email,@FormParam("motDePasse") String motDePasse)
	{
		Response resp =null;
		if("admin@pizzeria".equals(email) && "admin".equals(motDePasse)){
			UUID token=UUID.randomUUID();
			resp=Response.ok(token.toString()).build();
				}
		else {
			//case ko
			resp=Response.status(Status.FORBIDDEN).build();
		}
		return resp.toString();
	}
}
