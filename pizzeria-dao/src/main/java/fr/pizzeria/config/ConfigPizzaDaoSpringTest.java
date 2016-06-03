/**
 * 
 */
package fr.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.SpringPizzaDaoJpa;

/**
 * @author ETY
 *
 */
@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement(proxyTargetClass=true)
public class ConfigPizzaDaoSpringTest {

	@Bean
	public DataSource datasource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql")
				.addScript("db-data.sql").build();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		//return new DataSourceTransactionManager(datasource());
		return new JpaTransactionManager();
	}

	@Bean
	public LocalEntityManagerFactoryBean getEntityFactory()
	{
		LocalEntityManagerFactoryBean emf= new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-po");
		return emf ;
	}
	@Bean
	public IPizzaDao getPizzaDaoJpa() {
		return new SpringPizzaDaoJpa();
	}

}
