package com.airTransport.atm_backend.dto;

public class BookingDTO {
    private Long id;
    private Long flightId;
    private Long userId;  // New field for user ID
    private int travellerCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getUserId() {
        return userId;  // Getter for userId
    }

    public void setUserId(Long userId) {
        this.userId = userId;  // Setter for userId
    }

    public int getTravellerCount() {
        return travellerCount;
    }

    public void setTravellerCount(int travellerCount) {
        this.travellerCount = travellerCount;
    }
}
