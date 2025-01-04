package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightManagementService flightManagement;

    @Autowired
    private FlightSearchService flightSearch;

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/test")
    public String test() {
        return "Testing Flight Controller";
    }

    @PostMapping("/schedule")
    public boolean scheduleFlight(@RequestBody Flight flight) {
        return flightManagement.scheduleFlights(flight);
    }

    @DeleteMapping("/cancel/{flightId}")
    public boolean cancelFlight(@PathVariable long flightId) {
        return flightManagement.cancelFlights(flightId);
    }

    @GetMapping("/sort/price")
    public List<Flight> sortByPrice() {
        return flightSearch.sortByPrice();
    }

    @GetMapping("/sort/airline")
    public List<Flight> sortByAirline() {
        return flightSearch.sortByAirline();
    }

    @GetMapping("/sort/class")
    public List<Flight> sortByClass() {
        return flightSearch.sortByClass();
    }
    @PostMapping("/assign-passenger/{flightId}/{passengerId}")
    public String assignPassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {

        Flight flight = flightManagement.getFlightById(flightId);
        Passenger passenger = passengerService.getPassengerById(passengerId);

        if (flight != null && passenger != null) {
            List<Passenger> passengers = flight.getPassengers();
            passengers.add(passenger);
            flight.setPassengers(passengers);
            flightManagement.scheduleFlights(flight);
            return "Passenger assigned to flight successfully";
        }
        return "Flight or Passenger not found";
    }
}
