package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> addPassengersToBooking(List<Passenger> passengers, Long bookingId);
    List<Passenger> getPassengersByBookingId(Long bookingId);
    Passenger getPassengerById(Long passengerId);
}
