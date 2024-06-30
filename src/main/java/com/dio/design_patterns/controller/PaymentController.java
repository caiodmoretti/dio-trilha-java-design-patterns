package com.dio.design_patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.design_patterns.facade.PaymentFacade;
import com.dio.design_patterns.singleton.PaymentConfiguration;

@RestController
public class PaymentController {

    private final PaymentFacade paymentFacade;
    private final PaymentConfiguration paymentConfiguration;

    @Autowired
    public PaymentController(PaymentFacade paymentFacade, PaymentConfiguration paymentConfiguration) {
        this.paymentFacade = paymentFacade;
        this.paymentConfiguration = paymentConfiguration;
    }

    @GetMapping("/pay")
    public String pay(@RequestParam String method, @RequestParam double amount) {
        return paymentFacade.processPayment(method, amount);
    }

    @GetMapping("/config")
    public String getConfig() {
        return "Payment configuration value: " + paymentConfiguration.getInstancia();
    }

    @GetMapping("/setConfig")
    public String setConfig(@RequestParam String configValue) {
        paymentConfiguration.setConfigValue(configValue);
        return "Payment configuration value set to: " + configValue;
    }
}
