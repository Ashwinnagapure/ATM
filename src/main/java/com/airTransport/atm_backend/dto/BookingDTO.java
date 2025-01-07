package com.airTransport.atm_backend.dto;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private String passengerName;
    private String flightName;
    private LocalDateTime bookingDate;
    private LocalDateTime travelDate;
    private String status;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long id, String passengerName, String flightName, LocalDateTime bookingDate, LocalDateTime travelDate, String status) {
        this.id = id;
        this.passengerName = passengerName;
        this.flightName = flightName;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDateTime travelDate) {
        this.travelDate = travelDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
