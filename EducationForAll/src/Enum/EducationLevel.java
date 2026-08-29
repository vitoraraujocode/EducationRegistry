package Enum;
public enum EducationLevel { //Enum
	EARLY_CHILDHOOD("Educação Infantil"),
    ELEMENTARY("Ensino Fundamental"),
    HIGH_SCHOOL("Ensino Médio"),
    HIGHER_EDUCATION("Ensino Superior"),
    POSTGRADUATE("Pós-graduação");
	
	private String description; // Private attribute (encapsulation)

    EducationLevel(String a) { // Enum Constructor
        description = a;
    }

    public String getDescription() {return description; } // Get Method
}