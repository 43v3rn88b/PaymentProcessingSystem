package org.example.paymentprocessingsystem;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    // Wrap AROUND any method in the "processor" package to measure time
    @Around("execution(* org.example.paymentprocessingsystem.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // Start stopwatch

        Object result = joinPoint.proceed();     // Let the actual business method run

        long timeTaken = System.currentTimeMillis() - start; // Stop stopwatch
        System.out.println("[PERFORMANCE] " + joinPoint.getSignature().getName() + " took " + timeTaken + "ms");

        return result;
    }
}