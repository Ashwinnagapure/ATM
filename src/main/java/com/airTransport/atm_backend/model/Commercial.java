package com.airTransport.atm_backend.model;
import  com.airTransport.atm_backend.service.FlightSearch;
import java.util.List;

public class Commercial extends Booking implements FlightSearch{
    private long commercialId;
    private Payment payment;

    public boolean checkIn(String params){
     return true;
    }

    @Override
    public List<String> sortByPrice(String params) {
        return List.of();
    }

    @Override
    public List<String> sortByAirline(String params) {
        return List.of();
    }

    @Override
    public List<String> sortByClass(String params) {
        return List.of();
    }
}
