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
public interface DaoFactory {

	IClientDao getClientDao();
	ICommandeDao getCommandeDao();
	ILivreurDao getLivreurDao();
	IPizzaDao getPizzaDao();
	
}
