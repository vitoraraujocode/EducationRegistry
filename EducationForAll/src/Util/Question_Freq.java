package Util;
import javax.swing.JOptionPane; // Import for JOptionPane

public class Question_Freq {
	
	public static int questnote(String question) { // Static Method
		
		while (true){ // Loop Structure
			String quest_p1 = JOptionPane.showInputDialog(question); 
			// Abstraction: Method Call from Another class name JOptionPane getting user input
			
			if (quest_p1 == null ) { // conditional
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Você realmente quer sair do registro?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				// Abstraction: Method Call from Another class name JOptionPane getting user choice
				
				if (escolha == JOptionPane.OK_OPTION) { // conditional
			        return -1; 
			    } else {
			        continue; //repeat the loop 
			    }
				}			

			if (quest_p1.trim().isEmpty()) { // conditional empty string or if "   " (has space)
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Campo vazio! Deseja tentar novamente?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				// Abstraction: Method Call from Another class name JOptionPane getting user choice
				
				 if (escolha != JOptionPane.OK_OPTION) {return -1; } // conditional
				 continue; //repeat the loop 
			}			
			try {
				int resp_p1 = Integer.parseInt(quest_p1); // Type Conversion
				if ((resp_p1 < 0 || resp_p1 > 10)) { // conditional between 0 and 10
					int escolha = JOptionPane.showConfirmDialog(null,
    			            "Nota inválida precisa estar entre 0 e 10! Deseja tentar novamente?",
    			            "Erro",
    			            JOptionPane.OK_CANCEL_OPTION);
					
    				if (escolha != JOptionPane.OK_OPTION) {return -1; } // conditional
    				continue; //repeat the loop 
    				}
				
				return resp_p1; // return the answer for question 1
			}catch (NumberFormatException e) { // Exception Handling
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Nota errada! Deseja tentar novamente?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				
				if (escolha != JOptionPane.OK_OPTION) {return -1; } // conditional
				continue; //repeat the loop 
				}
			}
}
	
	public static String ask_yesno(String pergunta, String [] options) { // Static Method that returns String
		
		while(true) { // Loop Structure
			
			// Abstraction: using JOptionPane for option selection
			int quest_p2 = JOptionPane.showOptionDialog(null,
				pergunta,
				"Pergunta Específica",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
	            null,
	            options,
	            options[0]);
		
			if (quest_p2 == -1 ) { // conditional
				int escolha = JOptionPane.showConfirmDialog(null,
		            "Você realmente quer sair do registro?",
		            "Erro",
		            JOptionPane.OK_CANCEL_OPTION);
				// Abstraction: using JOptionPane for option selection
			
				if (escolha != JOptionPane.CANCEL_OPTION) {return null; } // conditional
				continue; //repeat the loop 
				}				
			return options[quest_p2]; //return the selected option
		}
	}
	
	public static int ask_option(String pergunta, String [] options) { // Static Method that returns int
		
		while(true) { // Loop Structure
			
		// Abstraction: using JOptionPane for option selection
			int quest_p2 = JOptionPane.showOptionDialog(null,
				pergunta,
				"Pergunta Específica",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
	            null,
	            options,
	            options[0]);
		
			if (quest_p2 == -1 ) { // conditional
				int escolha = JOptionPane.showConfirmDialog(null,
	            "Você realmente quer sair do registro?",
	            "Erro",
	            JOptionPane.OK_CANCEL_OPTION);
		
				if (escolha != JOptionPane.CANCEL_OPTION) {return -1; } // conditional
				continue; //repeat the loop 
				}				
			
			return quest_p2;  
	}
}
	
	public static String ask_write(String pergunta, String erro) { // Static Method that returns String
		while(true) { // Loop Structure
			
			// Abstraction: using JOptionPane to get text input
			String quest_p3 = JOptionPane.showInputDialog(pergunta);
			
			if (quest_p3 == null ) { // conditional
				int escolha = JOptionPane.showConfirmDialog(null,
			            erro,
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				
				 if (escolha != JOptionPane.CANCEL_OPTION) {return null; } // conditional
				 continue; //repeat the loop 
				}			

			if (quest_p3.trim().isEmpty()) { // conditional if string is empty or "   " (space)
				int escolha = JOptionPane.showConfirmDialog(null,
			            "Campo vazio! Deseja tentar novamente?",
			            "Erro",
			            JOptionPane.OK_CANCEL_OPTION);
				
				 if (escolha != JOptionPane.OK_OPTION) {return null; } // conditional
				 continue; //repeat the loop 
			}			
		return quest_p3;
		}
	}
}