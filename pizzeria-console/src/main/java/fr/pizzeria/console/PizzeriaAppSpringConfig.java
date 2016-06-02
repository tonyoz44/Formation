/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ETY
 *
 */
@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {


	@Bean	
	public Scanner getScanner()
	{
		Scanner sc = new Scanner(System.in);
		return sc;
	}
	@Bean
	public Scanner getScanners()
	{
		Scanner sc = new Scanner(System.in);
		return sc;
	}
	
	@Bean
	public  PropertyPlaceholderConfigurer prop()
	{
		PropertyPlaceholderConfigurer prop= new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}
	
	@Bean
	public DataSource returnDatasource(@Value("${jdbc.url}") String url, @Value("${jdbc.username}") String user,@Value("${jdbc.password}")String passsword)
	{
		 
	
		DataSource datasource= new DriverManagerDataSource(url,user,passsword);
		return datasource;
	}

	@Bean
	public DataSourceTransactionManager returnDataSTransaction(DataSource  re)
	{
		return new DataSourceTransactionManager(re);
	}
}
