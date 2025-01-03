package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/{adminId}/send/{passengerId}")
    public Notification sendNotificationToPassenger(@PathVariable Long adminId, @PathVariable Long passengerId, @RequestBody Notification notification) {
        return notificationService.sendNotificationToPassenger(adminId, passengerId, notification);
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id){
        notificationService.deleteNotificationById(id);
        return "Notification deleted";
    }
}
