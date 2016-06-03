/**
 * 
 */
package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ETY
 *
 */
@Entity
public class Performance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String service;
	Date date;
	Date tempsExecution;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Date tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	/**
	 * @return the tempsExecution
	 */
	public Date getTempsExecution() {
		return tempsExecution;
	}
	
}
