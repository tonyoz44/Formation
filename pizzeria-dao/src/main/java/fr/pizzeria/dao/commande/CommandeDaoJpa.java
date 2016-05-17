/**
 * 
 */
package fr.pizzeria.dao.commande;

import javax.persistence.EntityManagerFactory;

/**
 * @author ETY
 *
 */
public class CommandeDaoJpa implements ICommandeDao {

	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public CommandeDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
