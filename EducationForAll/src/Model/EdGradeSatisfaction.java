package Model;
import Enum.EducationLevel;
import Enum.LevelOption;

public class EdGradeSatisfaction { // Encapsulation
	private EducationLevel level; // Private enum attribute
    private int satisfaction; // Private attribute
    private LevelOption grade; // Private enum attribute

    public EdGradeSatisfaction(EducationLevel a, LevelOption b, int c) { // Constructor Method
        level = a;
        grade = b;
        satisfaction = c;
    }

    public EducationLevel getLevel() {return level;} // Getter Method

    public int getSatisfaction() {return satisfaction;} // Getter Method
    
    public LevelOption getGrade(){return grade;} // Getter Method
}