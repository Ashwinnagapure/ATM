package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.NotificationRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.NotificationService;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final AdminService adminService;
    private final PassengerService passengerService;

    public NotificationServiceImpl(NotificationRepository notificationRepository, AdminService adminService, PassengerService passengerService) {
        this.notificationRepository = notificationRepository;
        this.adminService = adminService;
        this.passengerService = passengerService;
    }


    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElseThrow(()-> new RuntimeException("No notification found with id: " + id));
    }

    @Override
    public Notification sendNotificationToPassenger(Long adminId, Long passengerId, Notification notification) {
        Admin admin = adminService.getAdminById(adminId);
        Passenger passenger = passengerService.getPassengerById(passengerId);

        notification.setAdmin(admin);
        notification.setRecipient(passenger);

        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public String deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
        return "Notification deleted with id: ";
    }
}
