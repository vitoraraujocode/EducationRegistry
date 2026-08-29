package Logic;
import Enum.EducationLevel;
import Enum.LevelOption;
import Model.EdGradeSatisfaction;
import Util.Question_Freq;

public class EducationQuestions {
	
	public static EdGradeSatisfaction choose_level() { // Static Method returns EdGradeSatisfaction
		
		EducationLevel level = null; // Enum usage
		// An enum uses encapsulation because it groups related constant values and controls access to them through methods.
		String [] education_options  = {"Ensino Infantil" , "Ensino Fundamental", "Ensino Médio",  
				" Ensino Superior " , " Pós- Graduação "}; // Size-fixed string array
		String p1 = "Qual nível de escolaridade você está ?";
		int education_level = Question_Freq.ask_option(p1, education_options); 
		// Abstraction: Method call from class Question_Freq 
		
		switch (education_level) { // Control conditional structure
			// Enum polymorphism, because different enum values represent different  meanings within the same type
			case 0: // if click in the first option is EARLY_CHILDHOOD
				level = EducationLevel.EARLY_CHILDHOOD; 
				break;
		
			case 1 : // if click in the second option is ELEMENTARY	
				level = EducationLevel.ELEMENTARY; 
				break;
		
			case 2: // if click in the third option is HIGH SCHOOL	
				level = EducationLevel.HIGH_SCHOOL; 
				break;
    	
			case 3: // if click in the fourth option is HIGHER EDUCATION	
				level = EducationLevel.HIGHER_EDUCATION; 
				break;
    	
			case 4: // if click in the fifth option is POSTGRADUATE	
				level = EducationLevel.POSTGRADUATE; 
				break;
    	
			default: // if don´t click in any of the options 
				return null;
	}
		
		LevelOption level_grade = null; // Enum usage 
		String p2 = "Seu nível de ensino selecionado é";
		String [] level_option  = {"Imcompleto" ,  " Completo "}; // Size-fixed string array
		int level_options = Question_Freq.ask_option(p2, level_option);
		// Abstraction: Method call from class Question_Freq 
			
			switch (level_options) { // Control conditional structure
			// Enum polymorphism
				case 0: // if click in the first option is UNFINISHED
					level_grade = LevelOption.UNFINISHED;  
					break;
			
				case 1 : // if click in the second option is FINISHED
					level_grade = LevelOption.FINISHED; 
					break;
        	
				default: // if don´t click in any of the options 
					return null;
    	}
			
			String general_ed = "De 0 a 10 qual é a sua satisfação com o nível de ensino?";
			int general_ed_quest = Question_Freq.questnote(general_ed);
			// Abstraction: Method call from class Question_Freq 
			if (general_ed_quest == -1) return null; // Conditional
        
			return new EdGradeSatisfaction(level, level_grade, general_ed_quest);
			// Return a new object from class EdGradeSatisfaction using the Constructor Method
	}
}