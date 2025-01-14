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
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class FlightController {

    @Autowired
    private FlightManagementService flightManagementService;
    @Autowired
    private FlightSearchService flightSearchService;

    // for admin
    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleFlight(@RequestBody FlightCreateDTO flightCreateDTO) {
        boolean isScheduled = flightManagementService.scheduleFlights(flightCreateDTO);
        return isScheduled ? ResponseEntity.ok("Flight scheduled successfully")
                : ResponseEntity.badRequest().body("Failed to schedule flight");
    }

    // for admin
    @DeleteMapping("/cancel/{flightId}")
    public ResponseEntity<String> cancelFlight(@PathVariable long flightId) {
        boolean isCancelled = flightManagementService.cancelFlights(flightId);
        return isCancelled ? ResponseEntity.ok("Flight cancelled successfully")
                : ResponseEntity.badRequest().body("Failed to cancel flight");
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

    //for user
    @GetMapping("/search")
    public ResponseEntity<List<FlightResponseDTO>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination) {
        List<FlightResponseDTO> flights = flightSearchService.searchFlights(source, destination);
        return ResponseEntity.ok(flights); // Return the list of flights based on source and destination
    }

    // for users as well as admin
    @GetMapping("/all")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        List<FlightResponseDTO> flights = flightManagementService.getAllFlights();
        return ResponseEntity.ok(flights);
    }


    @GetMapping("/airline/{airlineName}")
    public ResponseEntity<List<FlightResponseDTO>> getFlightsByAirline(@PathVariable String airlineName) {
        List<FlightResponseDTO> flights = flightSearchService.getFlightsByAirline(airlineName);
        return ResponseEntity.ok(flights);
    }


}
