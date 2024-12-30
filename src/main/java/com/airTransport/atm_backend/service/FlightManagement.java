package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Flight;

public interface FlightManagement {
    boolean trackFlightStatus(long flightId);
    boolean scheduleFlights(Flight flight);
    boolean cancelFlights(long flightId);
}
