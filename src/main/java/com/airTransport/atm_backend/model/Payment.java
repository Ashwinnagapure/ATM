package com.airTransport.atm_backend.model;

public class Payment {
    private long paymentId;
    private double amount;
    private Enum paymentMethod;
    private Enum paymentStatus;
    private String paymentDate;

    public boolean processPayment(String params) {
        // Implementation
        return true;
    }

    public boolean processRefund(String params) {
        // Implementation
        return true;
    }

    public boolean refundPayment(String params) {
        // Implementation
        return true;
    }


}
