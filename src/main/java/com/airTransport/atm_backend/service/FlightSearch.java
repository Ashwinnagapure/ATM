package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Flight;
import java.util.List;

public interface FlightSearch {
    List<Flight> sortByPrice();
    List<Flight> sortByAirline();
    List<Flight> sortByClass();
}
