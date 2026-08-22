package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Main.class,args);
        
//        PaymentGateway paymentGateway=context.getBean(PaymentGateway.class);
//
//        paymentGateway.print();
//        System.out.println(paymentGateway.getType());
//        System.out.println(paymentGateway.getRetryCount());
//        System.out.println(paymentGateway.getTimeout());
//        System.out.println(paymentGateway.isEnabled());
    }
}

// application.properties