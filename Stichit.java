package stichit;

import java.util.Scanner;

public class Stichit {

    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

        // Input for Customer
        System.out.println("Enter Customer Details:");
        System.out.print("Username: ");
        String custUsername = scanner.nextLine();
        System.out.print("Password: ");
        String custPassword = scanner.nextLine();
        System.out.print("Name: ");
        String custName = scanner.nextLine();
        System.out.print("Email: ");
        String custEmail = scanner.nextLine();
        System.out.print("Customer ID: ");
        String customerID = scanner.nextLine();

        Customer customer = new Customer(custUsername, custPassword, custName, custEmail, customerID);

        // Input for Tailor
        System.out.println("Enter Tailor Details:");
        System.out.print("Username: ");
        String tailorUsername = scanner.nextLine();
        System.out.print("Password: ");
        String tailorPassword = scanner.nextLine();
        System.out.print("Name: ");
        String tailorName = scanner.nextLine();
        System.out.print("Email: ");
        String tailorEmail = scanner.nextLine();
        System.out.print("Tailor ID: ");
        String tailorID = scanner.nextLine();

        Tailor tailor = new Tailor(tailorUsername, tailorPassword, tailorName, tailorEmail, tailorID);

        // Input for Administrator
        System.out.println("Enter Administrator Details:");
        System.out.print("Username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Password: ");
        String adminPassword = scanner.nextLine();
        System.out.print("Name: ");
        String adminName = scanner.nextLine();
        System.out.print("Email: ");
        String adminEmail = scanner.nextLine();
        System.out.print("Admin ID: ");
        String adminID = scanner.nextLine();

        Administrator admin = new Administrator(adminUsername, adminPassword, adminName, adminEmail, adminID);

        // Customer customizes design
        System.out.println("Enter Design Details:");
        String designDetails = scanner.nextLine();

        Customization customization = customer.getCustomization();
        try {
            customization.customizeDesign(designDetails);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.close();
            return;
        }

        // Input for Order
        System.out.println("Enter Order Details:");
        System.out.print("Order ID: ");
        String orderID = scanner.nextLine();

        Order order = new Order(orderID, customerID, tailorID, customization.getDesignDetails());

        // Payment Handling
        PaymentContext paymentContext = new PaymentContext();

        // Input for Payment
        System.out.println("Choose Payment Method (1 for Credit Card, 2 for PayPal): ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (paymentChoice == 1) {
            System.out.println("Enter Credit Card Details:");
            System.out.print("Card Number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Card Name: ");
            String cardName = scanner.nextLine();
            System.out.print("Card Expiry: ");
            String cardExpiry = scanner.nextLine();

            PaymentStrategy creditCard = new CreditCardPayment(cardNumber, cardName, cardExpiry);
            paymentContext.setPaymentStrategy(creditCard);

        } else if (paymentChoice == 2) {
            System.out.println("Enter PayPal Details:");
            System.out.print("Email: ");
            String email = scanner.nextLine();

            PaymentStrategy payPal = new PayPalPayment(email);
            paymentContext.setPaymentStrategy(payPal);
        } else {
            System.out.println("Invalid payment choice.");
            scanner.close();
            return;
        }

        // Input for Payment Amount
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();

        try {
            paymentContext.executePayment(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display the final order details
        System.out.println("\nFinal Order Details:");
        order.displayOrderDetails();

        scanner.close();
    }
}



