package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJPa;
import fr.pizzeria.dao.client.ClientDaoJdbc;
import fr.pizzeria.dao.commande.CommandeDaoJdbc;
import fr.pizzeria.dao.livreur.LivreurDaoJdbc;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJdbc;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;

public class DaoProducer {

	
	DaoFactory getDaoJpaFactory(EntityManagerFactory emf )
	{
		return new GenericFactoryImpl(new PizzaDaoJpa(), new ClientDaoJPa(),null,null);
		
	}

	DaoFactory getDaoJdbcFactory(EntityManagerFactory emf)
	{
		return new GenericFactoryImpl(new PizzaDaoJdbc(emf), new ClientDaoJdbc(emf),new CommandeDaoJdbc(emf),new LivreurDaoJdbc(emf));
	}
	DaoFactory getDaoFichierFactory()
	{
		return new GenericFactoryImpl(new PizzaDaoFichierImpl(),null,null,null);
	}
	DaoFactory getDaoImplFactory()
	{
		return new GenericFactoryImpl(new PizzaDaoImpl(),null,null,null);
	}
}
