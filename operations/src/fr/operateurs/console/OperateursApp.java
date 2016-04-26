/**
 * 
 */
package fr.operateurs.console;

import java.util.Scanner;

/**
 * @author ETY
 *
 */
public class OperateursApp{
	public static void main(String [] args){
		System.out.println("Veuillez saisir le premier nombre...");
		Scanner sc=new Scanner(System.in);
		Double nb1=sc.nextDouble();
		System.out.println("Veuillez saisir le second nombre...");
		Scanner sc2=new Scanner(System.in);

		Double nb2=sc2.nextDouble();
		System.out.println(nb1+"+"+nb2+"="+( nb1 +nb2));
		
	}

}
