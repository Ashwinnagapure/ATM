package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Testing endpoint
    @GetMapping("/test")
    public String test() {
        return "Testing Flight Controller";
    }

    // Get all flights
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        List<FlightResponseDTO> flights = flightSearch.sortByPrice(); // or another method to fetch all flights
        return ResponseEntity.ok(flights);
    }

    // Schedule a new flight
    @CrossOrigin(origins = "*")
    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleFlight(@RequestBody FlightCreateDTO flightCreateDTO) {
        boolean isScheduled = flightManagement.scheduleFlights(flightCreateDTO);
        if (isScheduled) {
            return ResponseEntity.ok("Flight scheduled successfully");
        }
        return ResponseEntity.badRequest().body("Failed to schedule the flight");
    }

    // Cancel a flight
    @DeleteMapping("/cancel/{flightId}")
    public ResponseEntity<String> cancelFlight(@PathVariable long flightId) {
        boolean isCancelled = flightManagement.cancelFlights(flightId);
        if (isCancelled) {
            return ResponseEntity.ok("Flight cancelled successfully");
        }
        return ResponseEntity.badRequest().body("Failed to cancel the flight");
    }

    // Sort flights by price
    @GetMapping("/sort/price")
    public ResponseEntity<List<FlightResponseDTO>> sortByPrice() {
        List<FlightResponseDTO> flights = flightSearch.sortByPrice();
        return ResponseEntity.ok(flights);
    }

    // Sort flights by airline
    @GetMapping("/sort/airline")
    public ResponseEntity<List<FlightResponseDTO>> sortByAirline() {
        List<FlightResponseDTO> flights = flightSearch.sortByAirline();
        return ResponseEntity.ok(flights);
    }

    // Sort flights by class
    @GetMapping("/sort/class")
    public ResponseEntity<List<FlightResponseDTO>> sortByClass() {
        List<FlightResponseDTO> flights = flightSearch.sortByClass();
        return ResponseEntity.ok(flights);
    }

    // Assign a passenger to a flight
//    @PostMapping("/assign-passenger/{flightId}/{passengerId}")
//    public ResponseEntity<String> assignPassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {
//        Flight flight = flightManagement.getFlightById(flightId);
//        Passenger passenger = passengerService.getPassengerById(passengerId);
//
//        if (flight != null && passenger != null) {
//            flight.getPassengers().add(passenger);
//            flightManagement.scheduleFlights(new FlightCreateDTO(flight));  // Schedule the flight again with updated passengers
//            return ResponseEntity.ok("Passenger assigned to flight successfully");
//        }
//        return ResponseEntity.badRequest().body("Flight or Passenger not found");
//    }

    // Get flight by ID
    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponseDTO> getFlightById(@PathVariable Long flightId) {
        FlightResponseDTO flight = flightManagement.getFlightById(flightId);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        }
        return ResponseEntity.notFound().build();
    }
}
