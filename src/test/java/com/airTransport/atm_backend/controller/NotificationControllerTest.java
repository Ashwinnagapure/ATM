package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationControllerTest {

    @InjectMocks
    private NotificationController notificationController;

    @Mock
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendNotificationToPassenger_Success() {
        Notification inputNotification = new Notification();
        inputNotification.setMessage("Test notification");

        Notification createdNotification = new Notification();
        createdNotification.setNotificationId(1L);
        createdNotification.setMessage("Test notification");

        when(notificationService.sendNotificationToPassenger(1L, 2L, inputNotification)).thenReturn(createdNotification);

        Notification result = notificationController.sendNotificationToPassenger(1L, 2L, inputNotification);

        assertNotNull(result);
        assertEquals(1L, result.getNotificationId());
        assertEquals("Test notification", result.getMessage());
        verify(notificationService, times(1)).sendNotificationToPassenger(1L, 2L, inputNotification);
    }

    @Test
    void testSendNotificationToPassenger_Failure_AdminNotFound() {
        Notification inputNotification = new Notification();
        inputNotification.setMessage("Test notification");

        when(notificationService.sendNotificationToPassenger(1L, 2L, inputNotification))
                .thenThrow(new RuntimeException("Admin not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationController.sendNotificationToPassenger(1L, 2L, inputNotification)
        );

        assertEquals("Admin not found", exception.getMessage());
        verify(notificationService, times(1)).sendNotificationToPassenger(1L, 2L, inputNotification);
    }

    @Test
    void testGetNotification_Success() {
        Notification mockNotification = new Notification();
        mockNotification.setNotificationId(1L);
        mockNotification.setMessage("Test notification");

        when(notificationService.getNotificationById(1L)).thenReturn(mockNotification);

        Notification result = notificationController.getNotification(1L);

        assertNotNull(result);
        assertEquals(1L, result.getNotificationId());
        assertEquals("Test notification", result.getMessage());
        verify(notificationService, times(1)).getNotificationById(1L);
    }

    @Test
    void testGetNotification_NotFound() {
        when(notificationService.getNotificationById(1L)).thenThrow(new RuntimeException("Notification not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationController.getNotification(1L)
        );

        assertEquals("Notification not found", exception.getMessage());
        verify(notificationService, times(1)).getNotificationById(1L);
    }

    @Test
    void testGetAllNotifications_Success() {
        Notification notification1 = new Notification();
        notification1.setNotificationId(1L);
        notification1.setMessage("Test notification 1");

        Notification notification2 = new Notification();
        notification2.getNotificationId();
        notification2.setMessage("Test notification 2");

        List<Notification> mockNotifications = Arrays.asList(notification1, notification2);

        when(notificationService.getAllNotifications()).thenReturn(mockNotifications);

        List<Notification> result = notificationController.getAllNotifications();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(notificationService, times(1)).getAllNotifications();
    }

    @Test
    void testGetAllNotifications_EmptyList() {
        when(notificationService.getAllNotifications()).thenReturn(Arrays.asList());

        List<Notification> result = notificationController.getAllNotifications();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(notificationService, times(1)).getAllNotifications();
    }

    @Test
    void testDeleteNotification_Success() {
        Long notificationId = 1L;
        String expectedResponse = "Notification deleted";

        // Mock the service behavior
        when(notificationService.deleteNotificationById(notificationId)).thenReturn(expectedResponse);

        // Call the controller method
        String result = notificationController.deleteNotification(notificationId);

        // Validate the response
        assertNotNull(result);
        assertEquals(expectedResponse, result);

        // Verify interaction with the service
        verify(notificationService, times(1)).deleteNotificationById(notificationId);
    }


    @Test
    void testDeleteNotification_NotFound() {
        doThrow(new RuntimeException("Notification not found")).when(notificationService).deleteNotificationById(1L);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                notificationController.deleteNotification(1L)
        );

        assertEquals("Notification not found", exception.getMessage());
        verify(notificationService, times(1)).deleteNotificationById(1L);
    }
}
