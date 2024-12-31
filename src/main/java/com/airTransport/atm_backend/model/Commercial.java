package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.service.FlightSearchService;

import java.util.List;

public class Commercial extends Booking implements FlightSearchService {
    private long commercialId;
    private Payment payment;


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
