package Enum;
public enum LevelOption { //Enum
	FINISHED ("Completo"),
    UNFINISHED ("Incompleto");
	
	private String description; // Private attribute (encapsulation)

    LevelOption(String a) { // Enum Constructor
        description = a;
    }
    public String getDescription() {return description;} // Get Method
}