
package stichit;

public class Customer extends User {
    
     private String customerID;
    private Customization customization;

    public Customer(String username, String password, String name, String email, String customerID) {
        super(username, password, name, email);
        this.customerID = customerID;
        this.customization = new Customization();
    }

    public Customization getCustomization() {
        return customization;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Customer Info: " + name + ", " + email + ", ID: " + customerID);
    }
}
