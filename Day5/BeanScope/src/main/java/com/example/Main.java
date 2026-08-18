package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order1=context.getBean(OrderService.class);
//        OrderService order2=context.getBean(OrderService.class);
//        System.out.println(order1==order2);
    }
}