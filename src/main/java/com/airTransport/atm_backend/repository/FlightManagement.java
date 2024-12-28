package com.airTransport.atm_backend.service;

public interface FlightManagement {
    public boolean trackFlightStatus();
    public boolean scheduleFlights();
    public boolean cancelFlights();
}
