
package stichit;
 interface PaymentStrategy {
     void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardName;
    private String cardExpiry;

    public CreditCardPayment(String cardNumber, String cardName, String cardExpiry) {
        if (cardNumber == null || cardNumber.isEmpty() || 
            cardName == null || cardName.isEmpty() || 
            cardExpiry == null || cardExpiry.isEmpty()) {
            throw new IllegalArgumentException("Card details cannot be null or empty");
        }
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpiry = cardExpiry;
    }

    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}

    

