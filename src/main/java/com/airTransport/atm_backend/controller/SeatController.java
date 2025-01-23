package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Seat;
import com.airTransport.atm_backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Get all seats for a specific flight
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<Seat>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<Seat> seats = seatService.getSeatsByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }

    // Get available seats for a specific flight
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/flight/{flightId}/available")
    public ResponseEntity<List<Seat>> getAvailableSeatsByFlightId(@PathVariable Long flightId) {
        List<Seat> availableSeats = seatService.getAvailableSeatsByFlightId(flightId);
        return ResponseEntity.ok(availableSeats);
    }

    // Update the availability of a specific seat
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PutMapping("/{seatId}/availability")
    public ResponseEntity<Seat> updateSeatAvailability(
            @PathVariable Long seatId, @RequestParam boolean isAvailable) {
        Seat updatedSeat = seatService.updateSeatAvailability(seatId, isAvailable);
        return ResponseEntity.ok(updatedSeat);
    }

    // Check if a specific seat is available
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/{seatId}/available")
    public ResponseEntity<Boolean> isSeatAvailable(@PathVariable Long seatId) {
        boolean isAvailable = seatService.isSeatAvailable(seatId);
        return ResponseEntity.ok(isAvailable);
    }

    // Add seats to a flight
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/flight/{flightId}")
    public ResponseEntity<List<Seat>> addSeatsToFlight(
            @RequestBody List<Seat> seats, @PathVariable Long flightId) {
        List<Seat> addedSeats = seatService.addSeatsToFlight(seats, flightId);
        return ResponseEntity.ok(addedSeats);
    }
}
