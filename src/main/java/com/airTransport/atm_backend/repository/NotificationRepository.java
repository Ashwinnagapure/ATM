package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Notification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository {
    private List<Notification> notifications = new ArrayList<>();

    public Notification save(Notification notification) {
        notification.setNotificationId(notifications.size() + 1); // Auto-increment logic
        notifications.add(notification);
        return notification;
    }

    public List<Notification> findAll() {
        return notifications;
    }

    public List<Notification> findByRecipient(String recipient) {
        List<Notification> result = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getRecipient().equalsIgnoreCase(recipient)) {
                result.add(notification);
            }
        }
        return result;
    }
}
