package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQueries({
@NamedQuery(name="pizza.findAll", query="select p from Pizza p")})
public class Pizza {

	@Id
	@GeneratedValue
	private Integer id;
	@ToString(uppercase = true)
	@Column()
	private String code;
	private String nom;
	@ToString(uppercase = true)
	private double prix;
	public static int nbPizzas;
	@Enumerated
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




	/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	*/
@Override
	   public int hashCode() {
		     // you pick a hard-coded, randomly chosen, non-zero, odd number
		     // ideally different for each class
		     return new HashCodeBuilder(17, 37).
		       append(code).
		       toHashCode();
		   }



	@Override
/*	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}*/
	 public boolean equals(Object obj) {
		   if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   Pizza rhs = (Pizza) obj;
		   return new EqualsBuilder()
		                 .appendSuper(super.equals(obj))
		                 .append(code, rhs.code)
		                 .append(categorie, rhs.categorie)
		                 .append(nom, rhs.nom)
		                 .append(prix, rhs.prix)
		                 .isEquals();
		  }



	public void setPrix(double bigDecimal) {
		this.prix = bigDecimal;
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
		
	 	List<Field> listChamp = Arrays.asList(Pizza.class.getDeclaredFields());
	 	
	 	
	 	Function<Field, ToString> fonction=(iterable_element)->iterable_element.getAnnotation(ToString.class);
	 	
	 	List<ToString> log= listChamp.stream().map(fonction).filter((ToString t) -> t!=null ).collect(Collectors.toList());
	 	//log.stream().map((ToString declaration,Object valueChamp) -> declaration  )
	 	
		
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
