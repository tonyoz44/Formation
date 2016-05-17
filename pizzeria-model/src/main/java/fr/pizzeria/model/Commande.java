/**
 * 
 */
package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author ETY
 *
 */
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@ManyToMany
	@JoinTable(name="commandePizza",joinColumns=
	@JoinColumn(name="idPizza",referencedColumnName="id"),
	inverseJoinColumns=
	@JoinColumn(name="idCommande",referencedColumnName="id"))
	Set<Pizza> listPizzas;
	Integer numero_commande;
	Date date_commande;
	Statut statut_commande;
	@ManyToOne
	@JoinColumn(name="liverid")
	Livreur livreur;
	@ManyToOne
	@JoinColumn(name="clientid")
	Client client;
	/**
	 * @param id
	 * @param numero_commande
	 * @param date_commande
	 * @param statut_commande
	 * @param livreur
	 * @param client
	 */
	public Commande(Integer numero_commande, Date date_commande, Statut statut_commande, Livreur livreur,
			Client client) {

		this.numero_commande = numero_commande;
		this.date_commande = date_commande;
		this.statut_commande = statut_commande;
		this.livreur = livreur;
		this.client = client;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the numero_commande
	 */
	public Integer getNumero_commande() {
		return numero_commande;
	}
	/**
	 * @param numero_commande the numero_commande to set
	 */
	public void setNumero_commande(Integer numero_commande) {
		this.numero_commande = numero_commande;
	}
	/**
	 * @return the date_commande
	 */
	public Date getDate_commande() {
		return date_commande;
	}
	/**
	 * @param date_commande the date_commande to set
	 */
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	/**
	 * @return the statut_commande
	 */
	public Statut getStatut_commande() {
		return statut_commande;
	}
	/**
	 * @param statut_commande the statut_commande to set
	 */
	public void setStatut_commande(Statut statut_commande) {
		this.statut_commande = statut_commande;
	}
	/**
	 * @return the livreur
	 */
	public Livreur getLivreur() {
		return livreur;
	}
	/**
	 * @param livreur the livreur to set
	 */
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	
}