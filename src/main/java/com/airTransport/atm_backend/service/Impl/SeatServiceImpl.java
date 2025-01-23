package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.EntityNotFoundException;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Seat;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.repository.SeatRepository;
import com.airTransport.atm_backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Optional<Seat> getSeatById(Long seatId) {
        return seatRepository.findById(seatId);
    }

    @Override
    public List<Seat> getSeatsByFlightId(Long flightId) {
        return seatRepository.findByFlightFlightId(flightId);
    }

    @Override
    public Seat updateSeatAvailability(Long seatId, boolean isAvailable) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with ID: " + seatId));
        seat.setAvailable(isAvailable);
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> addSeatsToFlight(List<Seat> seats, Long flightId) {
        // Fetch the flight by ID
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with ID: " + flightId));

        // Associate the flight with each seat
        seats.forEach(seat -> seat.setFlight(flight));

        // Save all the seats
        return seatRepository.saveAll(seats);
    }

    // New method to get all seats for a specific flight
    @Override
    public List<Seat> getAllSeatsByFlightId(Long flightId) {
        // Fetch all seats associated with the flight
        return seatRepository.findByFlightFlightId(flightId);
    }

    // New method to get available seats for a specific flight
    @Override
    public List<Seat> getAvailableSeatsByFlightId(Long flightId) {
        // Fetch all seats associated with the flight
        List<Seat> allSeats = seatRepository.findByFlightFlightId(flightId);

        // Filter and return only available seats
        return allSeats.stream()
                .filter(seat -> seat.isAvailable()) // Assuming 'isAvailable' is a boolean field
                .collect(Collectors.toList());
    }

    // New method to check if a specific seat is available
    @Override
    public boolean isSeatAvailable(Long seatId) {
        // Fetch the Seat by ID
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with ID: " + seatId));

        // Return the availability status of the seat
        return seat.isAvailable();
    }
}
