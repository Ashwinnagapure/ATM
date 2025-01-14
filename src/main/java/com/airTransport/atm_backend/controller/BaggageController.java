package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baggages")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class BaggageController {

    @Autowired
    private BaggageService baggageService;

    // Fetch all baggage for a specific booking
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<BaggageDTO>> getBaggageByBookingId(@PathVariable Long bookingId) {
        List<BaggageDTO> baggages = baggageService.getBaggageByBookingId(bookingId);
        return ResponseEntity.ok(baggages);
    }



    // Add a new baggage to a specific booking
//    @CrossOrigin(origins = "*")
    @PostMapping("/booking/{bookingId}")
    public ResponseEntity<BaggageDTO> addBaggageToBooking(@PathVariable Long bookingId, @RequestBody BaggageDTO baggageDTO) {
        BaggageDTO createdBaggage = baggageService.addBaggageToBooking(bookingId, baggageDTO);
        return ResponseEntity.ok(createdBaggage);
    }

    // Update baggage details
    @PutMapping("/{baggageId}")
    public ResponseEntity<BaggageDTO> updateBaggage(@PathVariable Long baggageId, @RequestBody BaggageDTO baggageDTO) {
        BaggageDTO updatedBaggage = baggageService.updateBaggage(baggageId, baggageDTO);
        return ResponseEntity.ok(updatedBaggage);
    }

    // Delete baggage by ID
    @DeleteMapping("/{baggageId}")
    public ResponseEntity<String> deleteBaggage(@PathVariable Long baggageId) {
        baggageService.deleteBaggage(baggageId);
        return ResponseEntity.ok("Baggage deleted successfully.");
    }
}
