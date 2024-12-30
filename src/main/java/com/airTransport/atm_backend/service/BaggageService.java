package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BaggageDTO;

import java.util.List;

public interface BaggageService {
    // Existing methods
    BaggageDTO getBaggageById(Long baggageId);
    List<BaggageDTO> getBaggageByBookingId(Long bookingId);
    BaggageDTO createBaggageFromParams(Long bookingId, boolean baggageLimit, Double weight, int luggageCount);

    // New methods
    boolean getBaggageLimit(Long baggageId);
    boolean reportLostBaggage(Long baggageId, String feedback);
}
