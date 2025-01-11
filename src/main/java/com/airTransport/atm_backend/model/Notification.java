package com.airTransport.atm_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notification")

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private String message;

    @ManyToOne
    @JoinColumn(name = "adminId",nullable = false)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger recipient;


    private Long recipientId;

    public Long getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Passenger getRecipient() {
        return recipient;
    }
    public void setRecipient(Passenger recipient) {
        this.recipient = recipient;
    }
    public Long getRecipientId() {
        return recipientId;
    }
    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }



}
