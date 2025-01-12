package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger, Long bookingId);
    List<Passenger> getPassengersByBookingId(Long bookingId);
    Passenger getPassengerById(Long passengerId);
    Passenger updatePassenger(Long passengerId, Passenger passenger);
    void deletePassenger(Long passengerId);
}
