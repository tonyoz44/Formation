package fr.pizzeria.dao.performance;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;


public interface PerformanceInterface extends JpaRepository<Performance,Integer> {

		
}
