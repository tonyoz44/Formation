package fr.pizzeria.model;

import java.lang.reflect.Field;

@Entity
public class Pizza {

	@SuppressWarnings("unused")
	private int id;
	@ToString(uppercase = true)
	private String code;
	private String nom;
	@ToString(uppercase = true)
	private double prix;
	public static int nbPizzas;
	CategoriePizza categorie;
	
	public CategoriePizza getCategorie() {
		return categorie;
	}



	
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}




	public Pizza()
	{
		
	}
	
	
	
	
	public Pizza(CategoriePizza categorie) {
		super();
		this.categorie = categorie;
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
	public Pizza(String code, String nom, double prix,CategoriePizza categorie) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie=categorie;
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
	
	@Override
	public String toString() {
		try {	
			
			
		for (Field iterable_element : Pizza.class.getDeclaredFields()) {
			
			ToString annotation =iterable_element.getAnnotation(ToString.class);
			
			if(annotation!=null)
			{

				boolean uppercase= annotation.uppercase();
			Object valeurDuChamp=	iterable_element.get(this);
			
			}
			
		}
		}
		catch(IllegalArgumentException | IllegalAccessException e)
		{
			
		};
		return this.nom +"Pizza de categorie"+ categorie ;
	}
	
}
