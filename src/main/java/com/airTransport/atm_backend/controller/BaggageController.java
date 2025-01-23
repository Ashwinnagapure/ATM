package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baggages")
public class BaggageController {

    @Value("${CORS}")
    private String corsUrl;

    @Autowired
    private BaggageService baggageService;

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<BaggageDTO>> getBaggageByBookingId(@PathVariable Long bookingId) {
        List<BaggageDTO> baggages = baggageService.getBaggageByBookingId(bookingId);
        return ResponseEntity.ok(baggages);
    }

    // Add a new baggage to a specific booking
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/booking/{bookingId}")
    public ResponseEntity<BaggageDTO> addBaggageToBooking(@PathVariable Long bookingId, @RequestBody BaggageDTO baggageDTO) {
        BaggageDTO createdBaggage = baggageService.addBaggageToBooking(bookingId, baggageDTO);
        return ResponseEntity.ok(createdBaggage);
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PutMapping("/{baggageId}")
    public ResponseEntity<BaggageDTO> updateBaggage(@PathVariable Long baggageId, @RequestBody BaggageDTO baggageDTO) {
        BaggageDTO updatedBaggage = baggageService.updateBaggage(baggageId, baggageDTO);
        return ResponseEntity.ok(updatedBaggage);
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @DeleteMapping("/{baggageId}")
    public ResponseEntity<String> deleteBaggage(@PathVariable Long baggageId) {
        baggageService.deleteBaggage(baggageId);
        return ResponseEntity.ok("Baggage deleted successfully.");
    }
}
