package fr.pizzeria.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJDBC implements IPizzaDao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private static final String REPERTOIRE_DATA = "src/main/resources/data";
	private static Connection connection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "anthony", "admin");
		connection.setAutoCommit(false);
		return connection;

	}

	public List<Pizza> findAllPizzas() throws DaoException {

		try (Connection connection = connection();
				Statement createStatement = connection.createStatement();

				ResultSet executeQuery = createStatement
						.executeQuery("select id,code_pizza,nom,prix,categorie from pizza");) {
			Pizza pizzaRecup = new Pizza();
			while (executeQuery.next()) {

				pizzaRecup.setNom(executeQuery.getString("NOM"));
				pizzaRecup.setPrix(executeQuery.getBigDecimal("PRIX"));
				pizzaRecup.setCategorie(CategoriePizza.valueOf(executeQuery.getString("CATEGORIE").toUpperCase()));
				pizzaRecup.setCode(executeQuery.getString("CODE_PIZZA"));
				System.out.println("[ name=" + pizzaRecup.getNom() + " price=" + pizzaRecup.getPrix() + "categorie"
						+ pizzaRecup.getCategorie().toString() + "]");
			}
			;
			pizzas.add(pizzaRecup);
		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return pizzas;

	}

	public boolean savePizza(Pizza newPizza) throws DaoException{
		boolean placeTrouve = false;
		int index;
		try (Connection connection = connection();) {
			PreparedStatement createStatement = connection.prepareStatement("insert into PIZZA (NOM,CODE_PIZZA,PRIX,CATEGORIE) values (?,?,?,?)");

			createStatement.setString(1, newPizza.getNom());
			createStatement.setString(2, newPizza.getCode());
			createStatement.setBigDecimal(3, newPizza.getPrix());
			createStatement.setString(4, newPizza.getCategorie().toString().toUpperCase());
			createStatement.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw new DaoException();
		}
	}

	public boolean updatePizza(String codePizza, Pizza updatePizza) {

		int index = 0;
		boolean test = false;
		// for (Pizza pizza : pizzas) {
		//
		// if(pizza.getCode().equals(codePizza) && pizza!=null)
		// {
		// pizzas.set(index, updatePizza);
		// test=true;
		// }
		// index++;
		// }

		Function<Pizza, Pizza> test1 = pizzaCherche -> pizzaCherche.getCode().equals(codePizza) ? updatePizza
				: pizzaCherche;
		pizzas = pizzas.stream().map(test1).collect(Collectors.toList());

		return test;
	}

	public static void main(String args[]) throws DaoException, SQLException {
		try {
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		
			connection();
			PizzaDaoJDBC imple = new PizzaDaoJDBC();
			try {
				imple.findAllPizzas();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Pizza>po =importation();
			for (Pizza pizza : po) {
				System.out.println(pizza.getCode());
			}
			
			List<List<Pizza>> partition = org.apache.commons.collections4.ListUtils.partition(po, 3);
			PizzaDaoJDBC pojdbc=new PizzaDaoJDBC();
			for (List<Pizza> list : partition) 
			{
				try(Connection connection=connection())
				{
					try{
					for (Pizza pizza : list) {
						pojdbc.savePizza(pizza);
					}
					
					connection.commit();}
					catch(SQLException e)
					{
						connection.rollback();
						System.out.println("erreur");
					}
					
				}	
			}
	
			
				
			
			
			Pizza pizza = new Pizza();
			pizza.setNom("pizzaya");
			pizza.setCode("PIZ");
			pizza.setPrix(new BigDecimal(12.8));
			pizza.setCategorie(CategoriePizza.POISSON);
			imple.savePizza(pizza);



	}
	public static List<Pizza> importation() throws DaoException
	{
		try {
			return Files.list(Paths.get(REPERTOIRE_DATA))
				.map(path -> {
					Pizza p = new Pizza();
					p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
					try {
						String ligne = Files.readAllLines(path).get(0);
						String[] ligneTab = ligne.split(";");
						p.setNom(ligneTab[0]);
						p.setPrix(new BigDecimal(ligneTab[1]));
						p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return p;
				})
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}
	//
	// @Override
	// public boolean savePizza(Pizza newPizza) throws DaoException {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean deletePizza(String codePizza) throws DaoException {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//



	@Override
	public boolean deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
