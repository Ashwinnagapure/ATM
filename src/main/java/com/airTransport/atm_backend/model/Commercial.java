package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.model.flight.Flight;
import com.airTransport.atm_backend.service.FlightSearch;
import java.util.List;

public class Commercial extends Booking implements FlightSearch {
    private long commercialId;
    private Payment payment;

    // Constructor
    public Commercial(long commercialId, Payment payment) {
        this.commercialId = commercialId;
        this.payment = payment;
    }

    // Getters and Setters
    public long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(long commercialId) {
        this.commercialId = commercialId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Business Logic
    public boolean checkIn(String params) {
        // Implement check-in logic
        return true; // Returning true as a placeholder
    }


    @Override
    public List<Flight> sortByPrice() {
        return List.of();
    }

    @Override
    public List<Flight> sortByAirline() {
        return List.of();
    }

    @Override
    public List<Flight> sortByClass() {
        return List.of();
    }
}
