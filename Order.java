
package stichit;

public class Order {
     private String orderID;
    private String customerID;
    private String tailorID;
    private String status;
    private String designDetails;

    public Order(String orderID, String customerID, String tailorID, String designDetails) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.tailorID = tailorID;
        this.designDetails = designDetails;
        this.status = "Pending";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderID + ", Customer ID: " + customerID + 
                           ", Tailor ID: " + tailorID + ", Status: " + status +
                           ", Design Details: " + designDetails);
    }
}

    

