package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightManagementService, FlightSearchService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AdminService adminService;

    // Implementation of FlightManagementService methods

    @Override
    public boolean trackFlightStatus(long flightId) {
        // Check if flight exists in the repository
        return flightRepository.existsById(flightId);
    }

    @Override
    public boolean scheduleFlights(Flight flight) {
        // Save the flight entity in the repository
        flightRepository.save(flight);
        return true;
    }

    @Override
    public boolean cancelFlights(long flightId) {
        // Check if flight exists and then delete
        if (flightRepository.existsById(flightId)) {
            flightRepository.deleteById(flightId);
            return true;
        }
        return false;
    }

    public List<Flight> getFlightsByAdmin(Long adminId) {
        // Fetch flights for a specific admin
        Admin admin = adminService.getAdminById(adminId);
        return admin.getFlights();
    }

    // Implementation of FlightSearchService methods

    @Override
    public List<Flight> sortByPrice() {
        // Sort flights by price
        return flightRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Flight> sortByAirline() {
        // Sort flights by airline
        return flightRepository.findAllByOrderByAirlineAsc();
    }

    @Override
    public List<Flight> sortByClass() {
        // Sort flights by class
        return flightRepository.findAllByOrderByFlightClassAsc();
    }

    // Additional Helper Methods

    public List<Flight> getAllFlights() {
        // Fetch all flights
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long flightId) {
        // Fetch a specific flight by ID
        return flightRepository.findById(flightId).orElse(null);
    }
}
