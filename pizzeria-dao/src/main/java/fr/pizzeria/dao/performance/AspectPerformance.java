/**
 * 
 */
package fr.pizzeria.dao.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ETY
 *
 */
@Aspect
@Component
public class AspectPerformance {

	@Autowired IPerformanceDao performanceDao;
	
	@Around("execution(* fr.pizzeria.dao.pizza.IPizzaDao.*(..))")
	public void profilerCreate(ProceedingJoinPoint pop) throws Throwable {

		System.out.println("passage Avant");

		
		
		Object valeurRetournee = pop.proceed();
		
		//performanceDao.save(performance);

		// noter le temps de fin et calculer le temps d’exécution



		}
}
