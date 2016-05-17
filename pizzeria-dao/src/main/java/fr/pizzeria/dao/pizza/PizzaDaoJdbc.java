package fr.pizzeria.dao.pizza;

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

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {
	private  final String DRIVER = "com.mysql.jdbc.Driver";
	private EntityManagerFactory emf;
	private  List<Pizza> pizzas = new ArrayList<Pizza>();
	private  final String REPERTOIRE_DATA = "src/main/resources/data";
	private  Connection connection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "anthony", "admin");
		connection.setAutoCommit(false);
		return connection;

	}

	/**
	 * @param emf
	 */
	public PizzaDaoJdbc(EntityManagerFactory emf) {
		this.emf = emf;
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


		Function<Pizza, Pizza> test1 = pizzaCherche -> pizzaCherche.getCode().equals(codePizza) ? updatePizza
				: pizzaCherche;
		pizzas = pizzas.stream().map(test1).collect(Collectors.toList());

		return test;
	}


	public  List<Pizza> importation() throws DaoException
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
