package com.airTransport.atm_backend.dto;

public class BaggageDTO {

    private Long id;
    private Double weight;
    private Boolean isOverweight;
    private Long bookingId; // Reference to the Booking ID, not the Booking object

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getIsOverweight() {
        return isOverweight;
    }

    public void setIsOverweight(Boolean isOverweight) {
        this.isOverweight = isOverweight;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
