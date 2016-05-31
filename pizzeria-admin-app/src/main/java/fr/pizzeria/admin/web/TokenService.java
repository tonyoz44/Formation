/**
 * 
 */
package fr.pizzeria.admin.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ETY
 *
 */
public class TokenService {

	
	private List<String> tokenValides =new ArrayList<>();
	
	public String generateNewToken()
	{
		String token=UUID.randomUUID().toString();
		tokenValides.add(token);
		return token;
		
	}
	
	public boolean isTokenValid(String token)
	{
		return tokenValides.contains(token);
	}
	
}
