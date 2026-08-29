package Model;

public class Person { // Encapsulation
	private String name; // Private attribute
	private int age; // Private attribute
	private final String country = "Brasil"; // Private final attribute
	private String city; // Private attribute
	private EdGradeSatisfaction educationLevel; // Private attribute
	private SpecificQuest p_resp; // Private attribute
	
	public Person (String a,int b,String c, EdGradeSatisfaction d, SpecificQuest e) { // Constructor Method
		name = a;
		setAge(b);
		city = c;
		educationLevel = d;
		p_resp = e;	
	}
	
	public Person() {} // Constructor Method (Overloading)

	public String getName() { return name; } // Getter Method
    
	public int getAge() { return age; } // Getter Method
    
    public String getCity() { return city; } // Getter Method
    
    public EdGradeSatisfaction getEducationLevel() { return educationLevel; } // Getter Method
    
    public SpecificQuest getSpecificQuest() { return p_resp; } // Getter Method
    
    public String getCountry() {return country;} // Getter Method
    
    public boolean setAge(int b) { // Set Method
    	if (b > 0 && b < 120) {
    	    age = b;
    	    return true;
    	} else {
    	    return false;
    	}
    }
    
    public void setName(String a) { name =  a; } // Set Method
    
    public void setCity(String b) { city = b; } // Set Method
    
    public void setEducationLevel(EdGradeSatisfaction c) { educationLevel = c; } // Set Method
    
    public void setStatus(SpecificQuest d) { p_resp = d;} // Set Method
    
}