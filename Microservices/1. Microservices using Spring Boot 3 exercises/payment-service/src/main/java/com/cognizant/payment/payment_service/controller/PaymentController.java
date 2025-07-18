package com.cognizant.payment.payment_service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    private static final String PAYMENT_SERVICE = "paymentCircuitBreaker";

    @GetMapping("/payment")
    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "fallbackPayment")
    @TimeLimiter(name = PAYMENT_SERVICE)
    public CompletableFuture<String> getPaymentStatus() {
        return CompletableFuture.supplyAsync(() -> {
            simulateSlowApi();
            return "Payment processed successfully!";
        });
    }

    public CompletableFuture<String> fallbackPayment(Throwable t) {
        return CompletableFuture.completedFuture("Payment service is currently unavailable. Please try again later.");
    }

    private void simulateSlowApi() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
