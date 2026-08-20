package com.example.payment;

public class CardPaymentService implements PaymentService1{
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
