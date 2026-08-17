package com.example;

import com.example.payment.CardPayment;
import com.example.payment.PaymentService;
import com.example.payment.UpiPayment;
import com.example1.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

    @Bean
    public User createUser(){
        return new User("Aditya",21);
    }

    @Bean
    public CartService createCartService(){
        return new CartService();
    }

    @Bean
    @Qualifier
    public PaymentService createCardPayment(){
        return new CardPayment();
    }

    @Bean
    @Qualifier
    public PaymentService createUpiPayment(){
        return new UpiPayment();
    }

    @Bean
    public OrderService createOrderService(@Qualifier("createUpiPayment") PaymentService paymentService){
        return new OrderService(paymentService);
    }

//    @Bean
//    public OrderService createOrderService(){
////        PaymentService payment=createCardPayment();
////        OrderService order=new OrderService();
////        order.setPaymentService(payment);
////        return order;
//
//        return new OrderService();
//    }
}
