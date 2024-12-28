package com.airTransport.atm_backend.model;

public class Flight {
    private long flightId;
    private long vehicleId ;
    private String flightName;
    private String departure;
    private String arrival;
    private Enum status;
    private String source ;
    private String destination;


    public Flight getFlightDetails(String params) {
        // Implementation
        return null;
    }

    public Boolean modifyFlightsDetails(String params) {
        // Implementation
        return null;
    }

    public Enum getFlightStatus(String params) {
        // Implementation
        return null;
    }

    public boolean updateFlightStatus(String params) {
        // Implementation
        return true;
    }



}