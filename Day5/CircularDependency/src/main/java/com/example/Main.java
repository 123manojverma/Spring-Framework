package com.example;

import com.example.simple.A;
import com.example.simple.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order=context.getBean(OrderService.class);
        order.placeOrder();

//        A a=new A();
    }
}