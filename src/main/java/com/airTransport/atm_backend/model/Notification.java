package com.airTransport.atm_backend.model;
import java.util.ArrayList;
import java.util.List;

public class Notification {
    private long notificationId;
    private String recipient;
    private Enum notificationType;
    private String status;

    public boolean sendNotification(String params) {
        // Implementation
        return true;
    }

    public List<Notification> receiveNotification(String params) {
        // Implementation
        return new ArrayList<>();
    }
}
