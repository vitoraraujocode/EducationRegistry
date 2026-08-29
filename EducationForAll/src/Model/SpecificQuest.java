package Model;
public class SpecificQuest {  // Encapsulation
	private String p1; // Private attribute
    private String p2; // Private attribute
    private int resp_p1; // Private attribute
    private String resp_p2; // Private attribute

    public SpecificQuest(String a, String b, int c, String d) { // Constructor Method
        p1 = a;
        p2 = b;
        resp_p1 = c;
        resp_p2 = d;
    }

    public String getP1() { return p1; } // Getter Method
    
    public String getP2() { return p2; } // Getter Method
    
    public int getResp1() { return resp_p1;} // Getter Method
    
    public String getResp2() { return resp_p2;} // Getter Method
}