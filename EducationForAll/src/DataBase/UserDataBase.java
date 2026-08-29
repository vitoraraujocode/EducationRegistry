package DataBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.User;
import java.sql.ResultSet;
import java.sql.Connection;

public class UserDataBase {

	public int addUser(User u) { // Method to add User, in your parameters has the User made in sign up
		String sql = "INSERT INTO users (email, password) VALUES (?, ?) RETURNING id"; //SQL INSERT query

        try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql) ) {
        	// DataBase Connection and Preparing an SQL statement

            stmt.setString(1, u.getEmail()); // Set parameters for the SQL statement
            stmt.setString(2, u.getPassword()); // Set parameters for the SQL statement
            ResultSet rs = stmt.executeQuery(); // Execute the query and get the result
            
         // Return the generated ID
            if (rs.next()) {
                return rs.getInt("id");
            }

        	} catch (SQLException e) { // Exception Handling
        		if (e.getSQLState().equals("23505")) { 
        			System.out.println("Email já existe");
        		} else {
        			e.printStackTrace();
        		}
        }
        return -1;
    }

	public User findUser(String email) { // Method to find User, in your parameters has the email put in sign in
	    String sql = "SELECT * FROM users WHERE email = ?"; //SQL INSERT query

	    try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	// DataBase Connection and Preparing an SQL statement

	        stmt.setString(1, email); // Set parameters for the SQL statement
	        ResultSet rs = stmt.executeQuery(); // Execute the query and get the result
	        
	        // Return the generated id, email and password
	        if (rs.next()) {
	        	int id_email = rs.getInt("id"); 
	            String userEmail = rs.getString("email");
	            String password = rs.getString("password");

	            return new User(id_email, userEmail, password); 
	            //return a user object instantiation to java because he does not have the informations of old data (Method Constructor)
	        }

	    } catch (SQLException e) { // Exception Handling
	        e.printStackTrace();
	    }

	    return null; // Return null if everything goes wrong
	}
}
