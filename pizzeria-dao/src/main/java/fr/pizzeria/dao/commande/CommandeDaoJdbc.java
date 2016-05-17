/**
 * 
 */
package fr.pizzeria.dao.commande;

import javax.persistence.EntityManagerFactory;

/**
 * @author ETY
 *
 */
public class CommandeDaoJdbc implements ICommandeDao {

	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public CommandeDaoJdbc(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
