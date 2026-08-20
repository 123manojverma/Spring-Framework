package com.example;

import com.example.payment.PaymentService1;

public class OrderService {

//    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService){
//        this.paymentService=paymentService;
//        System.out.println("OrderService Created");
//    }

//    public void setPaymentServiceBean(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    private PaymentService1 paymentService;

    public OrderService(PaymentService1 paymentService){
        this.paymentService=paymentService;
    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order placed");
    }
}
