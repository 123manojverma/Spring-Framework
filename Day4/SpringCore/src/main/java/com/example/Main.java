package com.example;

import com.example1.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order=context.getBean(OrderService.class);
        order.placeOrder();
//        PaymentService payment=context.getBean(PaymentService.class);
//        payment.pay();

//        CartService cs=context.getBean(CartService.class);
//        cs.addToCart();
//
//        User user=context.getBean(User.class);
//        System.out.println(user.getName());
    }
}