package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.repository.NotificationRepository;
import com.airTransport.atm_backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(Notification notification) {
        // Business logic for sending notification
        notification.setStatus("SENT");
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByRecipient(String recipient) {
        // Business logic for retrieving notifications for a recipient
        return notificationRepository.findByRecipient(recipient);
    }
}
