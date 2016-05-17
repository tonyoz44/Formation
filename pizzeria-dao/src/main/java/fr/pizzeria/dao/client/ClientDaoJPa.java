/**
 * 
 */
package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.pizzeria.model.Client;

/**
 * @author ETY
 *
 */
public class ClientDaoJPa implements IClientDao {

	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public ClientDaoJPa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void saveClient(Client client) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(client);
		transaction.commit();
		entityManager.close();
	}
	
	
}
