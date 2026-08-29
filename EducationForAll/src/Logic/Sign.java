package Logic;
import javax.swing.JOptionPane; // Import for JOptionPane
import DataBase.UserDataBase;
import Model.User;
import Util.Question_Freq;

public class Sign {
	public static User signUp(UserDataBase db) { // Static Method

	    String email = Question_Freq.ask_write("Digite seu email:", "Você quer ir ao menu"); 
	 // Abstraction: Method Call from Another Class
	    if (email == null) return null; // Conditional
	   

	    if (!email.endsWith("@gmail.com")) { // Conditional
	    	// Abstraction: using JOptionPane to show message
	        JOptionPane.showMessageDialog(null, "Email precisa ser @gmail.com");
	     // Abstraction: Method Call from Another Class
	        return null;
	    }

	    String password = Question_Freq.ask_write("Digite sua senha:", "Você quer ir ao menu"); 
	 // Abstraction: Method Call from Another Class
	    if (password == null) return null; // Conditional

	    
	    User newUser = new User(email, password); // Object Instantiation (Constructor Method)
	    int id = db.addUser(newUser); // Abstraction: Method Call from Another Class

	    if (id == -1) { // Conditional
	    	JOptionPane.showMessageDialog(null, "Usuário já existe");
	    	return null;
	    }
	    
	    JOptionPane.showMessageDialog(null, "Conta Criada");
	    return new User(id, email, password); 
	    // Return a new Object Instantiation with the informations from the class User (Constructor Method)   
	}
	
	public static User signIn(UserDataBase db) { // Static Method

	    String email = Question_Freq.ask_write("Digite seu email:", "Você quer ir ao menu");
	 // Abstraction: Method Call from Another Class
	    if (email == null) return null; // Conditional
	    
	    User user = db.findUser(email); // Abstract: Method Call from Another Class
	    if (user == null) { // Conditional
	    	 // Abstraction: using JOptionPane to show message
	        JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
	        return null;
	    }

	    String password = Question_Freq.ask_write("Digite sua senha:", "Você quer ir ao menu");
	 // Abstraction: Method Call from Another Class
	    if (password == null) return null; // Conditional

	    if (!user.getPassword().equals(password)) { // Conditional
	    	// Abstraction: using JOptionPane to show message
	        JOptionPane.showMessageDialog(null, "Senha incorreta!");
	        return null;
	    }
	    
	    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
	    return user; // Return the user of the database
	}
}
