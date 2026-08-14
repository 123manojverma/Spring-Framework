package com.example;

import com.example.notification.EmailService;
import com.example.notification.NotificationService;
import com.example.notification.SmsService;

public class OrderService {
//    NotificationService notification=new SmsService();
    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification=notification;
    }

    public OrderService(){};

    public void placeOrder(){
        System.out.println("Order Placed");
        // actual business logic
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
