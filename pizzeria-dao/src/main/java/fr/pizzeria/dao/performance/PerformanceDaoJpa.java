/**
 * 
 */
package fr.pizzeria.dao.performance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Performance;

/**
 * @author ETY
 *
 */
@Repository
public class PerformanceDaoJpa implements IPerformanceDao{

	@Autowired PerformanceInterface performanceImpl;
	
	@PersistenceContext private EntityManager entitymanager;
	
	@Override
	@Transactional
	public List<Performance> findAllPerformance() {
		
		
		return performanceImpl.findAll();
	}

	@Override
	@Transactional
	public void save(Performance performance) {

		performanceImpl.saveAndFlush(performance);
		
	}


}
