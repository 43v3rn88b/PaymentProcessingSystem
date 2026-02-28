package org.example.paymentprocessingsystem;


import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    // 2. CORE (Dependency Injection): Notice we NEVER use "new CreditCardProcessor()".
    // Spring sees this constructor and automatically hands this class the Processor it needs.
    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        if (amount <= 0) {
            throw new InvalidPaymentException("Payment failed: Amount must be greater than zero. Received: $" + amount);
        }

        System.out.println("Starting checkout process...");
        paymentProcessor.processPayment(amount);
    }
}