/**
 * 
 */
package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.model.Client;

/**
 * @author ETY
 *
 */
public class ClientDaoJPa implements IClientDao {

	@Autowired
	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public ClientDaoJPa() {
		
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
