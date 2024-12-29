package com.airTransport.atm_backend.dto;

import java.util.Date;

public class BookingDTO {

    private Long id;
    private String passengerName;
    private String flightNumber;
    private Date bookingDate;
    private Date flightDate;
    private String status;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long id, String passengerName, String flightNumber, Date bookingDate, Date flightDate, String status) {
        this.id = id;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.flightDate = flightDate;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}