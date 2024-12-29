package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.model.flight.Flight;

public class Booking {
    private long bookingId;
    private Passenger passenger;
    private Flight flight;
    private boolean meal;
    private Enum passengerType;
    private String bookingDate;
    private double fares;


    public boolean confirmBooking(String params) {
        // Implementation
        return true;
    }

    public boolean cancelBooking(String params) {
        // Implementation
        return true;
    }
}