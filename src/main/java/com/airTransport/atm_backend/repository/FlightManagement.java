package com.airTransport.atm_backend.repository;

public interface FlightManagement {
    public Enum trackFlightStatus();
    public boolean scheduleFlights();
    public boolean cancelFlights();
}
