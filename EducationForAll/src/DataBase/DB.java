package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	// Static final Attribute: Database connection URL (PostgreSQL)
	    private static final String URL = "jdbc:postgresql://localhost:5432/escolaridades_db";
	    private static final String USER = "postgres"; // Static final Attribute: Database username
	    private static final String PASSWORD = "1234"; // Static final Attribute: Database password

	    public static Connection connect() { // Static Method to establish and return a database connection
	    	try { // Attempt to create a connection to the database
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) { // Throw a runtime exception if the connection to the database fails
	        	throw new RuntimeException("Erro ao conectar com o banco", e);
	        }
	    }
	}
