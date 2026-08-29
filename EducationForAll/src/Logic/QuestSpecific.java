package Logic;
import Enum.EducationLevel;
import Model.SpecificQuest;
import Util.Question_Freq;

public class QuestSpecific {

    public static SpecificQuest getPerguntas(EducationLevel level) { // Method Static that returns class SpecificQuest
        switch (level) { // Control conditional structure
            case EARLY_CHILDHOOD: // if level is EARLY_CHILDHOOD
                return earlyChildhood(); // Abstract: Method Call from this Class
                
            case ELEMENTARY: // if level is ELEMENTARY
                return elementary(); // Abstract: Method Call from this Class
                
            case HIGH_SCHOOL: // if level is HIGH_SCHOOL
                return highSchool(); // Abstract: Method Call from this Class
                
            case HIGHER_EDUCATION: // if level is HIGHER_EDUCATION
                return higherEducation(); // Method Call from this Class
                
            case POSTGRADUATE: // if level is POSTGRADUATE
                return postGraduate(); // Abstract: Method Call from this Class
                
            default:
                return null; // If not is this cases, return null
        }
    }

    private static SpecificQuest earlyChildhood() { // Method that returns class SpecificQuest
    	String [] options  = {"Sim" , "Não", }; // Fixed-Size String Array 
    	
    	while(true) { // Loop Structure
    		String p1 = "De 0 a 10 a creche tinha boa estrutura?";
    		int resp_p1 = Question_Freq.questnote(p1); // Abstract: Method Call from Another Class
    		if (resp_p1 == -1) return null; // conditional
        
    		String p2 = "Seu filho(a)/você teve dificuldade em leitura?";
    		String resp_p2 = Question_Freq.ask_yesno(p2, options); // Abstract: Method Call from Another Class
    		if (resp_p2 == null) return null; // conditional

    		return new SpecificQuest(p1, p2, resp_p1, resp_p2); 
    		// Return a Object Instantiation with the informations get here in a class SpecificQuest (Method Constructor)
    	}
    }
    
    private static SpecificQuest elementary() { // Method that returns class SpecificQuest
    	String [] options  = {"Sim" , "Não", }; // Fixed-Size String Array 
    	
    	while (true) { // Loop Structure
    		String p1 = "De 0 a 10, como você avalia a qualidade dos professores no ensino fundamental?";
    		int resp_p1 = Question_Freq.questnote(p1); // Abstract: Method Call from Another Class
            if (resp_p1 == -1) return null; // conditional
    		
            String p2 = "Você/ Seu filho(a) teve dificuldades em matemática nesse nível?";
    		String resp_p2 = Question_Freq.ask_yesno(p2, options); // Abstract: Method Call from Another Class
            if (resp_p2 == null) return null;  // conditional
            
            return new SpecificQuest(p1, p2, resp_p1, resp_p2);
         // Return a new Object Instantiation with the informations get here in a class SpecificQuest (Method Constructor)
    	}
    }

    private static SpecificQuest highSchool() { // Method that returns class SpecificQuest
    	String [] options  = {"Sim" , "Não", }; // Fixed-Size String Array 
    	
    	while (true) { // Loop Structure
    		String p1 = "De 0 a 10 o quanto você se sentiu preparado para o ENEM?";
			int resp_p1 = Question_Freq.questnote(p1); // Abstract: Method Call from Another Class
            if (resp_p1 == -1) return null; // conditional
			
			String p2 = "O instituto de ensino ajudou na escolha de carreira?";
			String resp_p2 = Question_Freq.ask_yesno(p2, options); // Abstract: Method Call from Another Class
            if (resp_p2 == null) return null;  // conditional      
    		return new SpecificQuest(p1, p2, resp_p1, resp_p2);
    		 // Return a new Object Instantiation with the informations get here in a class SpecificQuest (Method Constructor)
    	}
    }
    
    private static SpecificQuest higherEducation() { // Method that returns class SpecificQuest
    	String [] options  = {"Sim" , "Não", }; // Fixed-Size String Array 
    	
    	while (true) { // Loop Structure
    		String p1 = "De 0 a 10, o ensino superior te preparou para o mercado de trabalho?";
    		int resp_p1 = Question_Freq.questnote(p1); // Abstract: Method Call from Another Class
            if (resp_p1 == -1) return null; // conditional
		
			String p2 = "Você conseguiu aplicar na prática o que aprendeu na faculdade?";
			String resp_p2 = Question_Freq.ask_yesno(p2, options); // Abstract: Method Call from Another Class
            if (resp_p2 == null) return null; 
            return new SpecificQuest(p1, p2, resp_p1, resp_p2); // conditional
            // Return a new Object Instantiation with the informations get here in a class SpecificQuest (Method Constructor)

    	}
    }
    
    private static SpecificQuest postGraduate() { // Method that returns class SpecificQuest
    	String [] options  = {"Sim" , "Não", }; // Fixed-Size String Array 
    	
    	while (true) { // Loop Structure
    		String p1 = "De 0 a 10, a pós-graduação agregou valor à sua carreira?";
    		int resp_p1 = Question_Freq.questnote(p1); // Abstract: Method Call from Another Class
            if (resp_p1 == -1) return null; // conditional
		
    		String p2 = "A pós-graduação trouxe novas oportunidades profissionais?";
    		String resp_p2 = Question_Freq.ask_yesno(p2, options); // Abstract: Method Call from Another Class
            if (resp_p2 == null) return null;  // conditional
            return new SpecificQuest(p1, p2, resp_p1, resp_p2);
            // Return a new Object Instantiation with the informations get here in a class SpecificQuest (Method Constructor)
    	}
    }
}