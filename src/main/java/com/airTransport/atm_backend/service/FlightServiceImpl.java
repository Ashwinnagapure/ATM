package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.flight.Flight;
import com.airTransport.atm_backend.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightSearch, FlightManagement {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public boolean trackFlightStatus(long flightId) {
        // Implement logic to track flight status
        return true;
    }

    @Override
    public boolean scheduleFlights(Flight flight) {
        flightRepository.save(flight);  // Save the flight to the database
        return true;
    }

    @Override
    public boolean cancelFlights(long flightId) {
        flightRepository.deleteById(flightId);  // Delete the flight from the database
        return true;
    }

    @Override
    public List<Flight> sortByPrice() {
        // Implement sorting by price if applicable
        return flightRepository.findAllByOrderByFlightClassAsc();  // This is just an example, adjust based on your business logic
    }

    @Override
    public List<Flight> sortByAirline() {
        // Implement sorting by airline
        return flightRepository.findAllByOrderByFlightClassAsc();  // Placeholder for actual sorting logic
    }

    @Override
    public List<Flight> sortByClass() {
        return flightRepository.findAllByOrderByFlightClassAsc();  // Sorting by flight class
    }
}
