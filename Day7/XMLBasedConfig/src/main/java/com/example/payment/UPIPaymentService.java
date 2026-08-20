package com.example.payment;

public class UPIPaymentService implements PaymentService1{

    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
