package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification getNotificationById(Long id);

    Notification sendNotificationToPassenger(Long adminId, Long passengerId, Notification notification);

    List<Notification> getAllNotifications();

    String deleteNotificationById(Long id);
}
