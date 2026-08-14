package com.example;

import com.example.notification.EmailService;
import com.example.notification.FakeEmailService;
import com.example.notification.NotificationService;
import com.example.notification.PopUpNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification=new FakeEmailService();
//        OrderService order= new OrderService(notification);
        OrderService order=new OrderService();
        order.setNotification(notification);
        order.placeOrder();
    }
}

// A class should ask what it needs, and not build everything itself

// IOC --> Inversion of control