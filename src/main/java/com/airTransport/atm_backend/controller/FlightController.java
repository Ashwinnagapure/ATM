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
public class FlightController {

    @Autowired
    private FlightManagementService flightManagementService;
    @Autowired
    private FlightSearchService flightSearchService;

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleFlight(@RequestBody FlightCreateDTO flightCreateDTO) {
        boolean isScheduled = flightManagementService.scheduleFlights(flightCreateDTO);
        return isScheduled ? ResponseEntity.ok("Flight scheduled successfully")
                : ResponseEntity.badRequest().body("Failed to schedule flight");
    }

    @DeleteMapping("/cancel/{flightId}")
    public ResponseEntity<String> cancelFlight(@PathVariable long flightId) {
        boolean isCancelled = flightManagementService.cancelFlights(flightId);
        return isCancelled ? ResponseEntity.ok("Flight cancelled successfully")
                : ResponseEntity.badRequest().body("Failed to cancel flight");
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponseDTO> getFlightById(@PathVariable Long flightId) {
        FlightResponseDTO flight = flightManagementService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/sort/price")
    public ResponseEntity<List<FlightResponseDTO>> sortByPrice() {
        return ResponseEntity.ok(flightSearchService.sortByPrice());
    }

    @GetMapping("/sort/airline")
    public ResponseEntity<List<FlightResponseDTO>> sortByAirline() {
        return ResponseEntity.ok(flightSearchService.sortByAirline());
    }

    @GetMapping("/sort/class")
    public ResponseEntity<List<FlightResponseDTO>> sortByClass() {
        return ResponseEntity.ok(flightSearchService.sortByClass());
    }
}
