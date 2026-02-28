package org.example.paymentprocessingsystem;

import org.springframework.stereotype.Component;

@Component // 1. CORE: This tells Spring to create and manage this object
public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Simulate a delay of 1 second for talking to the bank
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
}