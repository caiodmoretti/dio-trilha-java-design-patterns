package com.dio.design_patterns.singleton;

import org.springframework.stereotype.Component;

@Component
public class PaymentConfiguration {
    private String configValue;
    private static PaymentConfiguration instancia;
   
    private PaymentConfiguration() {
        super();
    }

    public static PaymentConfiguration getInstancia() {
        if(instancia == null) {
        	instancia = new PaymentConfiguration();
        }
    	return instancia;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}

