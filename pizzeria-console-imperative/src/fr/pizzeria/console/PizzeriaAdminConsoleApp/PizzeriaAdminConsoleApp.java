/**
 * 
 */
package fr.pizzeria.console.PizzeriaAdminConsoleApp;

import java.util.Scanner;

/**
 * @author ETY
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int test;
	Scanner sc =new Scanner(System.in);
	

		do
		{

		System.out.println("***** Pizzeria Administration *****\n1. Lister les pizzas\n2. Ajouter une nouvelle pizza\n3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza\n99. Sortir)");


		int numero=sc.nextInt();
		test=numero;
		switch (numero) {
		case 1:
			afficherListePizzas();
			break;
		case 2:
			System.out.println("Veuillez saisir le code");
			String code=sc.next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom=sc.next();
			
			System.out.println("Veuillez saisir le prix");
			Double prix=sc.nextDouble();
			ajouterPizza(code,nom,prix);
			afficherListePizzas();
			break;
		case 3:
			System.out.println("Mise à jour d’une pizza");
			afficherListePizzas();
			System.out.println("Veuillez choisir la pizza à modifier.");
			
			break;
		case 4:
			System.out.println("Suppression d’une pizza");
			break;
			default:
				break;		
		}
		}
		while(test!=99);
		sc.close();
	}

	private static void afficherListePizzas() {
		Object[][] tableauImp=  getTableau();
		int taille=0;
		for(int i = 0; i<tableauImp.length;i++)
		{
		if(tableauImp[i][0]!=null)
				{
					System.out.println(tableauImp[i][0]);
					taille++;
				};
		}
		
	}

	private static Object[][] getTableau() {
		Object[][] pizzas=new Object[100][3];
		pizzas[0]=new Object[]{ "PEP","Pépéroni",12.50};
		pizzas[1]=new Object[]{ "MAR","Margherita",14.00};
		pizzas[2]=new Object[]{ "REI","La Reine",11.50};
		pizzas[3]=new Object[]{ "FRO","La 4 fromages",12.00};					
		pizzas[4]=new Object[]{ "CAN","La cannibale",12.50}	;	
		pizzas[5]=new Object[]{ "SAV","La savoyarde",13.00};			
		pizzas[6]=new Object[]{ "ORI","L’orientale",13.50};
		pizzas[7]=new Object[]{ "IND","L’indienne",	14.00};
		return pizzas;
	}
		private static void  ajouterPizza(String code,String nom,double prix)
		{
			int tableauSize=getTableau().length;
			Object[][] pizzas=getTableau();
			pizzas[7]=new Object[]{ code,nom,prix};
		}
					
					
					
					
}
