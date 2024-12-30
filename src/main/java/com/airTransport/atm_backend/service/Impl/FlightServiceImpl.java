package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.service.FlightManagement;
import com.airTransport.atm_backend.service.FlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightManagement, FlightSearch {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public boolean trackFlightStatus(long flightId) {
        return flightRepository.existsById(flightId);
    }

    @Override
    public boolean scheduleFlights(Flight flight) {
        flightRepository.save(flight);
        return true;
    }

    @Override
    public boolean cancelFlights(long flightId) {
        if (flightRepository.existsById(flightId)) {
            flightRepository.deleteById(flightId);
            return true;
        }
        return false;
    }

    @Override
    public List<Flight> sortByPrice() {
        return flightRepository.findAll(Sort.by(Sort.Order.asc("price")));
    }

    @Override
    public List<Flight> sortByAirline() {
        return flightRepository.findAll(Sort.by(Sort.Order.asc("airline")));
    }

    @Override
    public List<Flight> sortByClass() {
        return flightRepository.findAll(Sort.by(Sort.Order.asc("flightClass")));
    }
}