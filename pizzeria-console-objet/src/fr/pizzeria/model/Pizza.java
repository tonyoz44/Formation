package fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int nbPizzas;
	public Pizza()
	{
		
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	public String getCode() {
		return code;
	}
	public String getNom() {
		return nom;
	}
	public double getPrix() {
		return prix;
	}
	
	
}
