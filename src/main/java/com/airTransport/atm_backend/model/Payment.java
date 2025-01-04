package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.model.enums.PaymentMethod;
import com.airTransport.atm_backend.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDate paymentDate;

    // Default constructor
    public Payment() {
    }

    @OneToOne
    @JoinColumn(name = "bookingId",referencedColumnName = "id")
    private Booking booking;

    @OneToOne(mappedBy = "payment",cascade = CascadeType.ALL)
    private BoardingPass bookingPass;


    // Constructor with parameters
    public Payment(double amount, PaymentMethod paymentMethod, PaymentStatus paymentStatus, LocalDate paymentDate,Booking booking) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.booking=booking;
    }

    // Getters and Setters
    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BoardingPass getBookingPass() {
        return bookingPass;
    }
    public void setBookingPass(BoardingPass bookingPass) {
        this.bookingPass = bookingPass;
    }
    // Other methods for processing payment and refunds
    public boolean processPayment() {
        // Payment processing logic (simplified here)
        if (this.paymentStatus == PaymentStatus.PENDING) {
            this.paymentStatus = PaymentStatus.SUCCESS;  // Example logic
            return true;
        }
        return false;
    }

    public boolean processRefund() {
        // Refund processing logic (simplified here)
        if (this.paymentStatus == PaymentStatus.SUCCESS) {
            this.paymentStatus = PaymentStatus.REFUNDED;
            return true;
        }
        return false;
    }
}
