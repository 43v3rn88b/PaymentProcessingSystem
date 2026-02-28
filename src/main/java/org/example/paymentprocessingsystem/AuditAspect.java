package org.example.paymentprocessingsystem;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Tells Spring this class contains AOP rules
@Component
public class AuditAspect {

    // Run this method BEFORE any method inside the "service" package runs
    @Before("execution(* org.example.paymentprocessingsystem.*.*(..))")
    public void logAuditCheck(JoinPoint joinPoint) {
        System.out.println("[AUDIT LOG] Security check passed. Authorized to execute: "
                + joinPoint.getSignature().getName());
    }
}