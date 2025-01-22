package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
public class FlightController {

    @Autowired
    private FlightManagementService flightManagementService;
    @Autowired
    private FlightSearchService flightSearchService;

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleFlight(@RequestBody FlightCreateDTO flightCreateDTO) {
        boolean isScheduled = flightManagementService.scheduleFlights(flightCreateDTO);
        return isScheduled ? ResponseEntity.ok("Flight scheduled successfully")
                : ResponseEntity.badRequest().body("Failed to schedule flight");
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/airline/{airlineName}")
    public ResponseEntity<List<FlightResponseDTO>> getFlightsByAirline(@PathVariable String airlineName) {
        List<FlightResponseDTO> flights = flightSearchService.getFlightsByAirline(airlineName);
        return ResponseEntity.ok(flights);
    }


    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @DeleteMapping("/cancel/{flightId}")
    public ResponseEntity<String> cancelFlight(@PathVariable long flightId) {
        boolean isCancelled = flightManagementService.cancelFlights(flightId);
        return isCancelled ? ResponseEntity.ok("Flight cancelled successfully")
                : ResponseEntity.badRequest().body("Failed to cancel flight");
    }


    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponseDTO> getFlightById(@PathVariable Long flightId) {
        FlightResponseDTO flight = flightManagementService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/sort/price")
    public ResponseEntity<List<FlightResponseDTO>> sortByPrice() {
        return ResponseEntity.ok(flightSearchService.sortByPrice());
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/sort/airline")
    public ResponseEntity<List<FlightResponseDTO>> sortByAirline() {
        return ResponseEntity.ok(flightSearchService.sortByAirline());
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/sort/class")
    public ResponseEntity<List<FlightResponseDTO>> sortByClass() {
        return ResponseEntity.ok(flightSearchService.sortByClass());
    }


    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/search")
    public ResponseEntity<List<FlightResponseDTO>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination) {
        List<FlightResponseDTO> flights = flightSearchService.searchFlights(source, destination);
        return ResponseEntity.ok(flights); // Return the list of flights based on source and destination
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        List<FlightResponseDTO> flights = flightManagementService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
}
