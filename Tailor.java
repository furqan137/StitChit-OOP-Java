
package stichit;


public class Tailor extends User {
     private String tailorID;

    public Tailor(String username, String password, String name, String email, String tailorID) {
        super(username, password, name, email);
        this.tailorID = tailorID;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Tailor Info: " + name + ", " + email + ", ID: " + tailorID);
    }
}
    
