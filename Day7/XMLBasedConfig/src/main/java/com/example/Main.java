package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

//        get bean by type
//        OrderService order=context.getBean(OrderService.class);

//        get bean by id/name
//        OrderService order=(OrderService) context.getBean("orderService");

//        OrderService order=context.getBean("orderServiceBean",OrderService.class);

//        PaymentService paymentService=context.getBean("paymentService", PaymentService.class);
//
//        paymentService.pay();
//        order.placeOrder();

        UserService user=context.getBean(UserService.class);

//        user.getUsername();
        context.close();
    }
}