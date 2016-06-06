/**
 * 
 */
package fr.pizzeria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ETY
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bob").password("secret").roles("USER");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Autowired
	public void configure(HttpSecurity http ) throws Exception {
	       http.authorizeRequests().anyRequest().authenticated()
	                      .and()
	                     .formLogin();
	
	}
}