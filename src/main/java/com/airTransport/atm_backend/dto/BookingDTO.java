package com.airTransport.atm_backend.dto;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private String passengerName;
    private String flightNumber;
    private LocalDateTime bookingDate;
    private LocalDateTime travelDate;
    private String status;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long id, String passengerName, String flightNumber, LocalDateTime bookingDate, LocalDateTime travelDate, String status) {
        this.id = id;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
