/**
 * 
 */
package fr.pizzeria.model;

/**
 * @author ETY
 *
 */
public enum CategoriePizza {
VIANDE("Viande"),POISSON("Poisson"),SANS_VIANDE("Sans Viande");

private String libelle;

private CategoriePizza(String arg0) {
	this.libelle=arg;
}

public String getLibelle() {
	return libelle;
}
	@Override
	public String toString()
	{
		return libelle;
		
	}
}
