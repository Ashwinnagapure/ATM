package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Baggage;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baggages")
public class BaggageController {

    @Autowired
    private BaggageService baggageService;

    // Fetch all baggage for a specific booking
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Baggage>> getBaggageByBookingId(@PathVariable Long bookingId) {
        List<Baggage> baggages = baggageService.getBaggageByBookingId(bookingId);
        return ResponseEntity.ok(baggages);
    }

    // Add a new baggage to a specific booking
    @PostMapping("/booking/{bookingId}")
    public ResponseEntity<Baggage> addBaggageToBooking(@PathVariable Long bookingId, @RequestBody Baggage baggage) {
        Baggage createdBaggage = baggageService.addBaggageToBooking(bookingId, baggage);
        return ResponseEntity.ok(createdBaggage);
    }

    // Update baggage details
    @PutMapping("/{baggageId}")
    public ResponseEntity<Baggage> updateBaggage(@PathVariable Long baggageId, @RequestBody Baggage baggage) {
        Baggage updatedBaggage = baggageService.updateBaggage(baggageId, baggage);
        return ResponseEntity.ok(updatedBaggage);
    }

    // Delete baggage by ID
    @DeleteMapping("/{baggageId}")
    public ResponseEntity<String> deleteBaggage(@PathVariable Long baggageId) {
        baggageService.deleteBaggage(baggageId);
        return ResponseEntity.ok("Baggage deleted successfully.");
    }
}
