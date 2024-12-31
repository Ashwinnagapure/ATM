package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification sendNotification(Notification notification);

    List<Notification> getNotificationsByRecipient(String recipient);
}
