/**
 * 
 */
package fr.pizzeria.dao.performance;

import java.util.List;

import fr.pizzeria.model.Performance;

/**
 * @author ETY
 *
 */
public interface IPerformanceDao {

	public List<Performance> findAllPerformance();
	public void save(Performance performance);
		
	
}
