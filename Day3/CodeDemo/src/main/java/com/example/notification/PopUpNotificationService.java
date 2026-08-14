package com.example.notification;

public class PopUpNotificationService implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("Pop-up Notification sent");
    }
}
