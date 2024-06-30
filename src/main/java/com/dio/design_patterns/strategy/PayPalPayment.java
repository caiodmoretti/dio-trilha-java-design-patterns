package com.dio.design_patterns.strategy;

import org.springframework.stereotype.Component;

@Component
public class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PayPal";
    }
}
