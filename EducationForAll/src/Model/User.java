package Model;
public class User { // Encapsulation
	private int id; // Private attribute
    private String email; // Private attribute
    private String password; // Private attribute
    
    public User(int id, String email, String password) { // Constructor Method
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String a, String b) { // Constructor Method (Overloading)
        email = a;
        password = b;
    }
   
    public int getId() {return id;} // Getter Method
    public String getEmail() { return email; } // Getter Method
    public String getPassword() { return password; } // Getter Method
}