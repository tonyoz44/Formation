/**
 * 
 */
package fr.pizzeria.dao.client;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.model.Client;

/**
 * @author ETY
 *
 */
public class ClientDaoJdbc implements IClientDao {

	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public ClientDaoJdbc(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		
	}
	
	
}
