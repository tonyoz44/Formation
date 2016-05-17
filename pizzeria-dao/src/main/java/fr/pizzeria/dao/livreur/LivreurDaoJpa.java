/**
 * 
 */
package fr.pizzeria.dao.livreur;

import javax.persistence.EntityManagerFactory;

/**
 * @author ETY
 *
 */
public class LivreurDaoJpa implements ILivreurDao {
	
	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public LivreurDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}
	

}
