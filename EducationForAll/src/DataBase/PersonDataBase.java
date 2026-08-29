package DataBase;
import java.sql.*;
import java.sql.Connection;
import Model.Person;
import Model.SpecificQuest;

public class PersonDataBase { 
	public int addPerson(Person p, int UserId) { 
		// Method to add Person, in your parameters has the Person and User id  made in Cadastro
		
		String sql = "INSERT INTO person " +
				"(name, age, city, education_level, education_status, satisfaction, user_id) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id"; //SQL INSERT query

		try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			// DataBase Connection and Preparing an SQL statement
			
			stmt.setString(1, p.getName()); // Set parameters for the SQL statement using the method get from person
            stmt.setInt(2, p.getAge()); // Set parameters for the SQL statement using the method get from person
            stmt.setString(3, p.getCity()); // Set parameters for the SQL statement using the method get from person
            stmt.setString(4, p.getEducationLevel().getLevel().getDescription()); // Set parameters for the SQL statement 
            stmt.setString(5, p.getEducationLevel().getGrade().getDescription()); // Set parameters for the SQL statement 
            stmt.setInt(6, p.getEducationLevel().getSatisfaction()); // Set parameters for the SQL statement
            stmt.setInt(7, UserId); // Set parameters for the SQL statement using the UserId from Cadastro

			ResultSet rs = stmt.executeQuery();  // Execute the query and get the result
			
			
			if (rs.next()) { // Return the generated ID
				return rs.getInt("id"); 
			}

			} catch (SQLException e) { // Exception Handling
				e.printStackTrace();
			}

		return -1;
	}
	
	public void addSpecificQuestions(int personId, SpecificQuest spec) { 
		// Method to add Specific Questions, in your parameter has the personId made in method add person
		// This method also have a parameter spec, get in Cadastro

		String sql = "INSERT INTO specific_questions " + "(person_id, question1, answer1, question2, answer2) " 
		+"VALUES (?, ?, ?, ?, ?)"; //SQL INSERT query

		try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			// DataBase Connection and Preparing an SQL statement
			
			stmt.setInt(1, personId); // Set parameters for the SQL statement using the method get from method add person
			stmt.setString(2, spec.getP1()); // Set parameters for the SQL statement using the method get from SpecificQuest
			stmt.setInt(3, spec.getResp1()); // Set parameters for the SQL statement using the method get from SpecificQuest
			stmt.setString(4, spec.getP2()); // Set parameters for the SQL statement using the method get from SpecificQuest
			stmt.setString(5, spec.getResp2()); // Set parameters for the SQL statement using the method get from SpecificQuest
			
			// Execute the SQL INSERT statement
			stmt.executeUpdate();

		} catch (SQLException e) { // Exception Handling
			e.printStackTrace();
		}
	}
}