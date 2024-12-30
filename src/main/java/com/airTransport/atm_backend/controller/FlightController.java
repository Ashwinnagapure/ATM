package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.service.FlightManagement;
import com.airTransport.atm_backend.service.FlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightManagement flightManagement;

    @Autowired
    private FlightSearch flightSearch;

    @GetMapping("/test")
    public String test() {
        return "FlightController is working!";
    }


    @PostMapping("/schedule")
    public boolean scheduleFlight(@RequestBody Flight flight) {
        return flightManagement.scheduleFlights(flight);
    }

    @DeleteMapping("/cancel/{flightId}")
    public boolean cancelFlight(@PathVariable long flightId) {
        return flightManagement.cancelFlights(flightId);
    }

    @GetMapping("/status/{flightId}")
    public boolean trackFlightStatus(@PathVariable long flightId) {
        return flightManagement.trackFlightStatus(flightId);
    }

    @GetMapping("/sort/price")
    public List<Flight> sortFlightsByPrice() {
        return flightSearch.sortByPrice();
    }

    @GetMapping("/sort/airline")
    public List<Flight> sortFlightsByAirline() {
        return flightSearch.sortByAirline();
    }

    @GetMapping("/sort/class")
    public List<Flight> sortFlightsByClass() {
        return flightSearch.sortByClass();
    }
}
