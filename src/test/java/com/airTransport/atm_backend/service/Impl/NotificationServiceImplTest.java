package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.NotificationRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {

    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private AdminService adminService;

    @Mock
    private PassengerService passengerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetNotificationById_Found() {
        Notification mockNotification = new Notification();
        mockNotification.setNotificationId(1L);
        when(notificationRepository.findById(1L)).thenReturn(Optional.of(mockNotification));

        Notification result = notificationService.getNotificationById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getNotificationId());
        verify(notificationRepository, times(1)).findById(1L);
    }

    @Test
    void testGetNotificationById_NotFound() {
        when(notificationRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationService.getNotificationById(1L)
        );

        assertEquals("No notification found with id: 1", exception.getMessage());
        verify(notificationRepository, times(1)).findById(1L);
    }

    @Test
    void testSendNotificationToPassenger_Success() {
        Admin admin = new Admin();
        admin.setId(1L);

        Passenger passenger = new Passenger();
        passenger.setId(2L);

        Notification notification = new Notification();
        notification.setNotificationId(3L);

        when(adminService.getAdminById(1L)).thenReturn(admin);
        when(passengerService.getPassengerById(2L)).thenReturn(passenger);
        when(notificationRepository.save(notification)).thenReturn(notification);

        Notification result = notificationService.sendNotificationToPassenger(1L, 2L, notification);

        assertNotNull(result);
        assertEquals(3L, result.getNotificationId());
        assertEquals(admin, result.getAdmin());
        assertEquals(passenger, result.getRecipient());
        verify(adminService, times(1)).getAdminById(1L);
        verify(passengerService, times(1)).getPassengerById(2L);
        verify(notificationRepository, times(1)).save(notification);
    }

    @Test
    void testSendNotificationToPassenger_AdminNotFound() {
        when(adminService.getAdminById(1L)).thenThrow(new RuntimeException("Admin not found with id: 1"));

        Notification notification = new Notification();

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationService.sendNotificationToPassenger(1L, 2L, notification)
        );

        assertEquals("Admin not found with id: 1", exception.getMessage());
        verify(adminService, times(1)).getAdminById(1L);
        verify(passengerService, times(0)).getPassengerById(anyLong());
        verify(notificationRepository, times(0)).save(any(Notification.class));
    }

    @Test
    void testSendNotificationToPassenger_PassengerNotFound() {
        Admin admin = new Admin();
        admin.setId(1L);

        when(adminService.getAdminById(1L)).thenReturn(admin);
        when(passengerService.getPassengerById(2L)).thenThrow(new RuntimeException("Passenger not found with id: 2"));

        Notification notification = new Notification();

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationService.sendNotificationToPassenger(1L, 2L, notification)
        );

        assertEquals("Passenger not found with id: 2", exception.getMessage());
        verify(adminService, times(1)).getAdminById(1L);
        verify(passengerService, times(1)).getPassengerById(2L);
        verify(notificationRepository, times(0)).save(any(Notification.class));
    }

    @Test
    void testGetAllNotifications_Success() {
        Notification notification1 = new Notification();
        notification1.setNotificationId(1L);

        Notification notification2 = new Notification();
        notification2.setNotificationId(2L);

        List<Notification> mockNotifications = Arrays.asList(notification1, notification2);
        when(notificationRepository.findAll()).thenReturn(mockNotifications);

        List<Notification> result = notificationService.getAllNotifications();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(notificationRepository, times(1)).findAll();
    }

    @Test
    void testGetAllNotifications_EmptyList() {
        when(notificationRepository.findAll()).thenReturn(Collections.emptyList());

        List<Notification> result = notificationService.getAllNotifications();


        assertTrue(result.isEmpty());
        verify(notificationRepository, times(1)).findAll();
    }

    @Test
    void testDeleteNotificationById_Success() {
        doNothing().when(notificationRepository).deleteById(1L);

        String result = notificationService.deleteNotificationById(1L);

        assertEquals("Notification deleted with id: ", result);
        verify(notificationRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteNotificationById_NotFound() {
        doThrow(new RuntimeException("Notification not found with id: 1")).when(notificationRepository).deleteById(1L);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationService.deleteNotificationById(1L)
        );

        assertEquals("Notification not found with id: 1", exception.getMessage());
        verify(notificationRepository, times(1)).deleteById(1L);
    }
}
