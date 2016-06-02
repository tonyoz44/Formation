/**
 * 
 */
package fr.pizzeria.dao.pizza;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author ETY
 *
 */
@EnableJpaRepositories("fr.pizzeria.dao")
public class ConfigRepositoryDao {

	@Bean

	public JpaTransactionManager transactionManager() {

	JpaTransactionManager txManager = new JpaTransactionManager();

	txManager.setEntityManagerFactory(entityManagerFactory());

	return txManager;
	}
	@Bean

	public EntityManagerFactory entityManagerFactory() {

	LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
	return factory;

	}
	@Bean
	public DataSource datasource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql")
				.addScript("db-data.sql").build();
	}
	
	
}
