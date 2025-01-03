package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BaggageDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaggageService {
    // Existing methods
    BaggageDTO getBaggageById(Long baggageId);
    List<BaggageDTO> getBaggageByBookingId(Long bookingId);


    // New methods
    boolean getBaggageLimit(Long baggageId);
    boolean reportLostBaggage(Long baggageId, String feedback);

    @Transactional
    BaggageDTO createBaggageFromParams(Long bookingId, boolean baggageLimit, double weight, int luggageCount);
}
