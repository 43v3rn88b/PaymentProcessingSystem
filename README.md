Payment Processing System (Core, AOP & REST)
--------------------------------------------------

This project showcases deep knowledge of the Spring Framework's internal mechanics, focusing on decoupled architecture and cross-cutting concerns.

### 🚀 Overview

A secure, audited REST API for processing payments. This project avoids "spaghetti code" by using Aspect-Oriented Programming (AOP) to separate business logic from technical concerns like logging and performance monitoring.

### 🛠️ Key Features

*   **Spring Core (IoC/DI):** Demonstrated loose coupling by injecting different payment implementations (PayPal vs. Credit Card) using @Primary and @Component.
    
*   **Aspect-Oriented Programming (AOP):** \* **Security Audit:** Automatically logs service access without touching business logic.
    
    *   **Performance Monitoring:** Measures and logs execution time for payment processing in milliseconds.
        
*   **Global Exception Handling:** Implemented @ControllerAdvice to intercept errors and return clean, user-friendly HTTP 400 responses.
    
*   **RESTful API:** Exposed service layer via a RestController to handle real-time HTTP POST requests.
    

### 🏗️ Tech Stack

*   **Java 17+**
    
*   **Spring Boot 3.x**
    
*   **Spring AOP**
    
*   **Spring Web**
    

### 🚦 How to Test

1.  Run the application.
    
2.  ```Bash
    curl -X POST "http://localhost:8080/api/payments/checkout?amount=150.00"```
    ```
3.  ```Bash
    curl -X POST "http://localhost:8080/api/payments/checkout?amount=-5.00"
    ```
4.  Observe the IDE console to see the **AOP Audit Logs** and **Performance Metrics** running in the background.

🛣️ Production Roadmap
----------------------

This service is designed as a modular core. To transition this into a full-scale microservices architecture, the following features would be implemented:

*   **Security & Identity:** Replace the current open access with **Spring Security (OAuth2/JWT)** to ensure that only authenticated "Order Services" can trigger the payment process.
    
*   **Service Discovery & Resilience:** Integrate with **Netflix Eureka** for service discovery and implement the **Circuit Breaker pattern (Resilience4j)** to handle cases where external payment providers (PayPal/Banks) are down.
    
*   **Asynchronous Messaging:** Introduce **Apache Kafka** or **RabbitMQ** to send "Payment Completed" events back to an Order or Shipping service, ensuring eventual consistency without blocking the user.
    
*   **Distributed Tracing:** Implement **Micrometer Tracing (formerly Spring Cloud Sleuth)** and **Zipkin** to track a single transaction’s journey across multiple services for easier debugging.
    
*   **Database Auditing:** Enable **Spring Data Envers** or JPA Auditing to automatically track the created\_by and modified\_at timestamps for every payment transaction record.
