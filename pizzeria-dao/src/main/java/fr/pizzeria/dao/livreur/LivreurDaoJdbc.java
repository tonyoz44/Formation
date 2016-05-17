/**
 * 
 */
package fr.pizzeria.dao.livreur;

import javax.persistence.EntityManagerFactory;

/**
 * @author ETY
 *
 */
public class LivreurDaoJdbc implements ILivreurDao {

	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public LivreurDaoJdbc(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
