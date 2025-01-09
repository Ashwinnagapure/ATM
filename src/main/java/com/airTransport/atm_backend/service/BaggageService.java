package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Baggage;

import java.util.List;

public interface BaggageService {
    List<Baggage> getBaggageByBookingId(Long bookingId);

    Baggage addBaggageToBooking(Long bookingId, Baggage baggage);

    Baggage updateBaggage(Long baggageId, Baggage baggage);

    void deleteBaggage(Long baggageId);
}
