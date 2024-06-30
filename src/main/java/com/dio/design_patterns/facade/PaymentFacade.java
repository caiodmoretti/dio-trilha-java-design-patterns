package com.dio.design_patterns.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dio.design_patterns.strategy.CreditCardPayment;
import com.dio.design_patterns.strategy.PayPalPayment;

@Component
public class PaymentFacade {

    private final CreditCardPayment creditCardPayment;
    private final PayPalPayment payPalPayment;

    @Autowired
    public PaymentFacade(CreditCardPayment creditCardPayment, PayPalPayment payPalPayment) {
        this.creditCardPayment = creditCardPayment;
        this.payPalPayment = payPalPayment;
    }

    public String processPayment(String method, double amount) {
        switch (method.toLowerCase()) {
            case "creditcard":
                return creditCardPayment.pay(amount);
            case "paypal":
                return payPalPayment.pay(amount);
            default:
                return "Invalid payment method";
        }
    }
}

