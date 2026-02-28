package org.example.paymentprocessingsystem;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Tells Spring this class handles errors globally
public class GlobalExceptionHandler {

    // Tells Spring: "If you see an InvalidPaymentException, route it here!"
    @ExceptionHandler(InvalidPaymentException.class)
    public ResponseEntity<String> handleInvalidPayment(InvalidPaymentException ex) {

        System.out.println("[ERROR CAUGHT] " + ex.getMessage());

        // Return a clean "400 Bad Request" status code with our custom message
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}