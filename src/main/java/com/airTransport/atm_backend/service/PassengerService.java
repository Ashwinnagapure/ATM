package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Passenger;

import java.util.List;

public interface PassengerService {
    // Modified method to include seatId
    List<Passenger> addPassengersToBooking(List<Passenger> passengers, Long bookingId, Long userId, List<Long> seatIds);

    List<Passenger> getPassengersByBookingId(Long bookingId);
    Passenger getPassengerById(Long passengerId);

    // New method to get all passengers associated with a particular user ID
    List<Passenger> getPassengersByUserId(Long userId);
}
