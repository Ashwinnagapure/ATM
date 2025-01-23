package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    // Method to fetch a seat by its ID
    Optional<Seat> getSeatById(Long seatId);

    // Method to fetch all seats associated with a specific flight
    List<Seat> getSeatsByFlightId(Long flightId);

    // Method to update the availability of a seat
    Seat updateSeatAvailability(Long seatId, boolean isAvailable);

    // Method to add seats to a flight
    List<Seat> addSeatsToFlight(List<Seat> seats, Long flightId);

    // New method to get all seats for a specific flight
    List<Seat> getAllSeatsByFlightId(Long flightId);

    // New method to get available seats for a specific flight
    List<Seat> getAvailableSeatsByFlightId(Long flightId);

    // New method to check if a specific seat is available
    boolean isSeatAvailable(Long seatId);
}
