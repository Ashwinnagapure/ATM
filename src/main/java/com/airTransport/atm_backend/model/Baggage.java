package com.airTransport.atm_backend.model;

import jakarta.persistence.*;

@Entity
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long baggageId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private boolean baggageLimit;
    private Double weight;
    private int luggageCount;

    @Column(name = "feedback", length = 1000)
    private String feedback; // Field to store user feedback or story

    // Getters and setters
    public long getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(long baggageId) {
        this.baggageId = baggageId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public boolean getBaggageLimit() {
        return baggageLimit;
    }

    public void setBaggageLimit(boolean baggageLimit) {
        this.baggageLimit = baggageLimit;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount = luggageCount;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // Business methods
    public boolean checkBaggageLimit(String params) {
        // Logic for checking baggage limit
        return baggageLimit;
    }

    public boolean reportLostBaggage(String feedback) {
        // Logic for reporting lost baggage by saving feedback
        this.feedback = feedback;
        return true;
    }
}
