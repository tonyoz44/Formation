package fr.pizzeria.dao;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.commande.ICommandeDao;
import fr.pizzeria.dao.livreur.ILivreurDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;

public class GenericFactoryImpl implements DaoFactory {

	IPizzaDao pizzaDao;
	IClientDao clientDao;
	ICommandeDao commandeDao;
	ILivreurDao livreurDao;

	public GenericFactoryImpl(IPizzaDao pizzaDao, IClientDao clientDao, ICommandeDao commmandeDao,
			ILivreurDao livreurDao) {

		this.clientDao = clientDao;
		this.commandeDao = commmandeDao;
		this.livreurDao = livreurDao;
		this.pizzaDao = pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		check(clientDao);
		return clientDao;
	}

	@Override
	public ICommandeDao getCommandeDao() {
		check(commandeDao);
		return commandeDao;
	}

	@Override
	public ILivreurDao getLivreurDao() {
		check(livreurDao);

		return livreurDao;
	}

	@Override
	public IPizzaDao getPizzaDao() {
		check(pizzaDao);
		return pizzaDao;
	}

	private void check(Object implementation) {
		if (implementation == null) {
			throw new NotImplementedException("Dao non implémenté");
		}
	}
}
