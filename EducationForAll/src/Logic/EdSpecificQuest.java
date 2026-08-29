package Logic;
import Enum.EducationLevel;
import Model.SpecificQuest;

public class EdSpecificQuest {
	public static SpecificQuest getPerguntas(EducationLevel level) { // Method Static that returns class SpecificQuest
			
		switch (level) { // Control conditional structure
	
			case EARLY_CHILDHOOD: // if level is EARLY_CHILDHOOD
				return QuestSpecific.getPerguntas(level);	// Method Call from QuestSpecific
				
			case ELEMENTARY: // if level is ELEMENTARY
				return QuestSpecific.getPerguntas(level); // Method Call from QuestSpecific
				
			case HIGH_SCHOOL: // if level is HIGH_SCHOOL
				return QuestSpecific.getPerguntas(level); // Method Call from QuestSpecific

			case HIGHER_EDUCATION: // if level is HIGHER_EDUCATION
				return QuestSpecific.getPerguntas(level); // Method Call from QuestSpecific
        	
        	case POSTGRADUATE: // if level is POSTGRADUATE
        		return QuestSpecific.getPerguntas(level); // Method Call from QuestSpecific
        	
        	default: 
        		return null; // If not is this cases, return null
    }  
   }
}