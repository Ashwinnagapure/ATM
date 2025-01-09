package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/{bookingId}")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger, @PathVariable Long bookingId) {
        Passenger createdPassenger = passengerService.addPassenger(passenger, bookingId);
        return ResponseEntity.ok(createdPassenger);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Passenger>> getPassengersByBookingId(@PathVariable Long bookingId) {
        List<Passenger> passengers = passengerService.getPassengersByBookingId(bookingId);
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long passengerId) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.ok(passenger);
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long passengerId, @RequestBody Passenger passenger) {
        Passenger updatedPassenger = passengerService.updatePassenger(passengerId, passenger);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok("Passenger deleted successfully");
    }
}
