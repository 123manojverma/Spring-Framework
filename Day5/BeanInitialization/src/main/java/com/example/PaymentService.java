package com.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {

    OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService=orderService;
        System.out.println("PaymentService Created");
    }

    public void pay(){
        System.out.println("Payment done");

        orderService.getOrderDetails();
    }
}
