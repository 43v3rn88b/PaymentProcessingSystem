package org.example.paymentprocessingsystem;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PaypalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Redirecting to PayPal...");
        System.out.println("Processing PayPal payment of $" + amount);
        // Simulate a slightly longer delay for PayPal
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }
}