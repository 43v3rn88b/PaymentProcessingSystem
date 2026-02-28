package org.example.paymentprocessingsystem;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells Spring this class handles web requests and returns data (not HTML views)
@RequestMapping("/api/payments") // The base URL for this controller
public class PaymentController {

    private final CheckoutService checkoutService;

    // Dependency Injection! Spring hands the Controller the Service it needs.
    public PaymentController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    // Listens for POST requests at /api/payments/checkout
    @PostMapping("/checkout")
    public String processWebPayment(@RequestParam double amount) {
        System.out.println("--- Web Request Received ---");

        // Pass the web input down into your core logic
        checkoutService.checkout(amount);

        return "Successfully triggered payment process for $" + amount;
    }
}