package org.example.paymentprocessingsystem;


// Extending RuntimeException means we don't have to add "throws" to every method signature
public class InvalidPaymentException extends RuntimeException {

    public InvalidPaymentException(String message) {
        super(message);
    }
}
