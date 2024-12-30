package com.airTransport.atm_backend.repository;

public interface FlightManagement {
    public boolean trackFlightStatus();
    public boolean scheduleFlights();
    public boolean cancelFlights();
}
