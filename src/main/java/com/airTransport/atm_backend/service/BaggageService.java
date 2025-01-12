package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BaggageDTO;
import java.util.List;

public interface BaggageService {
    List<BaggageDTO> getBaggageByBookingId(Long bookingId);
    BaggageDTO addBaggageToBooking(Long bookingId, BaggageDTO baggageDTO);
    BaggageDTO updateBaggage(Long baggageId, BaggageDTO baggageDTO);
    void deleteBaggage(Long baggageId);
}
