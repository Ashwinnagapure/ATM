package com.airTransport.atm_backend.dto;

public class BaggageDTO {

    private Long baggageId;
    private Long bookingId;  // To represent the related Booking
    private boolean baggageLimit;
    private Double weight;
    private int luggageCount;
    private String feedback; // New field for feedback

    // Constructor
    public BaggageDTO(Long baggageId, Long bookingId, boolean baggageLimit, Double weight, int luggageCount, String feedback) {
        this.baggageId = baggageId;
        this.bookingId = bookingId;
        this.baggageLimit = baggageLimit;
        this.weight = weight;
        this.luggageCount = luggageCount;
        this.feedback = feedback;
    }

    // Getters and setters
    public Long getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(Long baggageId) {
        this.baggageId = baggageId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isBaggageLimit() {
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
}
