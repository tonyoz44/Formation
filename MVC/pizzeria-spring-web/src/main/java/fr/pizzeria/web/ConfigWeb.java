/**
 * 
 */
package fr.pizzeria.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ETY
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "fr.pizzeria.web", "fr.pizzeria.dao" })
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao")
public class ConfigWeb {

	@Bean

	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// factory.setDataSource(dataSource());
		factory.setPersistenceUnitName("pizzeria-spring");
		return factory;

	}

	@Bean

	public PlatformTransactionManager transactionManager() {

		return new JpaTransactionManager();

	}

	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
