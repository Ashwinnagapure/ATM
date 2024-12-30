package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baggage")
public class BaggageController {

    @Autowired
    private BaggageService baggageService;

    // Existing endpoints...

    @GetMapping("/{baggageId}")
    public BaggageDTO getBaggageById(@PathVariable Long baggageId) {
        return baggageService.getBaggageById(baggageId);
    }

    @GetMapping("/byBooking/{bookingId}")
    public List<BaggageDTO> getBaggageByBookingId(@PathVariable Long bookingId) {
        return baggageService.getBaggageByBookingId(bookingId);
    }

    @PostMapping("/create")
    public BaggageDTO createBaggage(@RequestBody BaggageDTO baggageDTO) {
        return baggageService.createBaggageFromParams(
                baggageDTO.getBookingId(),
                baggageDTO.isBaggageLimit(),
                baggageDTO.getWeight(),
                baggageDTO.getLuggageCount());
    }



    // New endpoints for the methods
    @GetMapping("/limit/{baggageId}")
    public boolean getBaggageLimit(@PathVariable Long baggageId) {
        return baggageService.getBaggageLimit(baggageId);
    }


    @PostMapping("/lost/{baggageId}")
    public boolean reportLostBaggage(@PathVariable Long baggageId, @RequestBody String feedback) {
        return baggageService.reportLostBaggage(baggageId, feedback);
    }

}
