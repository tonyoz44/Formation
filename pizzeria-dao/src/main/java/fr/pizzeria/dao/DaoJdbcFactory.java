/**
 * 
 */
package fr.pizzeria.dao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.commande.ICommandeDao;
import fr.pizzeria.dao.livreur.ILivreurDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

/**
 * @author ETY
 *
 */
public class DaoJdbcFactory implements DaoFactory {

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.DaoFactory#getClientDao()
	 */
	@Override
	public IClientDao getClientDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.DaoFactory#getCommandeDao()
	 */
	@Override
	public ICommandeDao getCommandeDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.DaoFactory#getLivreurDao()
	 */
	@Override
	public ILivreurDao getLivreurDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.DaoFactory#getPizzaDao()
	 */
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
