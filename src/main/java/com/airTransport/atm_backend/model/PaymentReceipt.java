package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import java.io.File;

@Entity
@Table(name = "payment_receipts")
public class PaymentReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "bookingId",referencedColumnName = "id")
    private Booking booking;

    // Getters and Setters
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public File downloadReceipt(String params) {
        // Placeholder logic for receipt download
        return null;
    }

    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
