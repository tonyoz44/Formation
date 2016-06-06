/**
 * 
 */
package fr.pizzeria.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author ETY
 *
 */
public class SecurityWebApplicationInitializer extends

		AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}


}
