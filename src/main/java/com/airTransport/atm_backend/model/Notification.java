package com.airTransport.atm_backend.model;

import  com.airTransport.atm_backend.model.enums.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class Notification {
    private long notificationId;
    private String recipient;
    private NotificationType notificationType; // Enum
    private String status;

    public boolean sendNotification(String params) {
        // Placeholder implementation for sending notification
        return true;
    }

    public List<Notification> receiveNotification(String params) {
        // Placeholder implementation for receiving notifications
        return new ArrayList<>();
    }

    // Getters and Setters
    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
