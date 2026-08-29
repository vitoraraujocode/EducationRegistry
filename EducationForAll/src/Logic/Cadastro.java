package Logic;
import javax.swing.JOptionPane;
import DataBase.PersonDataBase;
import Model.EdGradeSatisfaction;
import Model.Person;
import Model.SpecificQuest;
import Util.Question_Freq;

public class Cadastro {
	public static boolean register(int UserId) { // Static Method return boolean and using UserId from Menu
        
		String p1 = "Qual é o seu nome?";
		String name = Question_Freq.ask_write(p1, "Você quer ir ao menu de registro de escolaridades");
		// Abstraction: Method call from class Question_Freq 
		if (name == null) return false;
		Person person = new Person(); // Object instantiation (Constructor Method)
		
		String age;
		int age_person;	
		
		while (true){ // Loop structure
			age = JOptionPane.showInputDialog("Quantos anos você tem?");
			
			if (age == null ) { // Conditional
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Você realmente quer sair do registro?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				
				 if (escolha != JOptionPane.CANCEL_OPTION) {return false; } // Conditional
				 continue; //repeat the loop
				}
	
			if (age.trim().isEmpty()) { // conditional empty string or if "   " (has space)
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Campo vazio! Deseja tentar novamente?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				
				 if (escolha != JOptionPane.OK_OPTION) { return false; } // Conditional
				 
				 continue; //repeat the loop
			}
			
			try {
				age_person = Integer.parseInt(age); // Convert string to int in age
				if (!person.setAge(age_person)) { // Encapsulation: method set to setting age
					int escolha = JOptionPane.showConfirmDialog(
    			            null,
    			            "Idade inválida precisa estar entre 0 e 120! Deseja tentar novamente?",
    			            "Erro",
    			            JOptionPane.OK_CANCEL_OPTION
    			        );
    				if (escolha != JOptionPane.OK_OPTION) { // Conditional
			            return false; 
			        }
    				continue; // repeat the loop
    				}
				
	        	break; 
			}catch (NumberFormatException e) { // Exception Handling
				int escolha = JOptionPane.showConfirmDialog(
			            null,
			            "Idade inválida! Deseja tentar novamente?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION
			        );
				if (escolha != JOptionPane.OK_OPTION) { // Conditional
		            return false; 
		        }
				continue; // repeat the loop
				}
			}
		String p2 = "Em que cidade você mora";
		String city = Question_Freq.ask_write(p2, "Você quer ir ao menu de registro de escolaridades");
		// Abstraction: Method call from class Question_Freq 
		if (city == null) return false;	
		
    	EdGradeSatisfaction level = EducationQuestions.choose_level();
    	// Abstraction: Method call from class EducationQuestions that returns an object from class EdGradeSatisfaction
    	if (level == null) {
    	    return false; 
    	}
    	person.setEducationLevel(level); // Encapsulation: method set to setting level of education
    	
    	SpecificQuest spec = EdSpecificQuest.getPerguntas(level.getLevel());
    	// Abstraction: Method call from class EdSpecificQuest that returns an object from class SpecificQuest
    	if (spec == null) {
    	    return false;
    	}
  
    	// Encapsulation: method set to setting name and city
    	person.setName(name);
        person.setCity(city);
        
    	
    	PersonDataBase pdb = new PersonDataBase(); // Object instantiation (Constructor Method)

        int personId = pdb.addPerson(person, UserId ); // Abstraction: saving object person into database
     // Abstraction: Method call from class PersonDataBase that returns an id type int.

        if (personId == -1) return false;

       
        pdb.addSpecificQuestions(personId,spec); 
        // Abstraction: saving object SpecificQuest and related addPerson information into database

		return true;
	}
}