package Main;
import javax.swing.JOptionPane; // Import for JOptionPane
import Logic.Cadastro;
import Logic.Sign;
import Model.User;
import DataBase.UserDataBase;
import Util.Question_Freq;

public class Menu {

	public static void main(String[] args) { // Main Method
		
		UserDataBase db = new UserDataBase(); // Object Instantiation (Constructor Method)
		

		while (true) { // Loop Structure
			String[] firstOptions = {"Sign Up", "Sign In"}; // Fixed-Size String Array 
			int choice;
			User logged = null;
		
		do { //Post-tested loop 
			choice = Question_Freq.ask_option("Bem-vindo!", firstOptions); 
			// Abstraction: Method call from class Question_Freq 
			if (choice == -1) return; // conditional	

			if (choice == 0) { // conditional
				logged = Sign.signUp(db); // Abstraction: Method call from class Sign
			} else {
				logged = Sign.signIn(db); // Abstraction: Method call from class Sign
			};
			
			} while(logged == null); // Loop Conditional
			int userId = logged.getId(); // Encapsulation: method get to access private attribute
		
	
        String [] options = {"Registrar Pessoa" }; // Fixed-Size String Array 
        int option;
        
        do { //Post-tested loop 
        	String p1 = "Bem vindo ao Programa para Registrar o nível de escolaridade das pessoas";
			option = Question_Freq.ask_option(p1, options); // Abstraction: Method call from class Question_Freq 
            if (option == -1) break; // conditional
        	
        	if (option == 0) { // conditional
        		boolean cad = Cadastro.register(userId); // // Abstraction: Method call from class Cadastro
        		if (cad == true) { // conditional
        			JOptionPane.showMessageDialog(
        				    null,
        				    "Pessoa Cadastrada",
        				    "Cadastro",
        				    JOptionPane.INFORMATION_MESSAGE
        				); 
        		}
        		continue; //repeat the loop
        	} 
        	
        } while (option != -1); // condition to allow the block to be repeated
		}
	}
}
