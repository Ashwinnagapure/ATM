package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.EntityNotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.Seat;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.repository.SeatRepository;
import com.airTransport.atm_backend.repository.UserRepository;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository; // Add SeatRepository

    @Override
    public List<Passenger> addPassengersToBooking(List<Passenger> passengers, Long bookingId, Long userId, List<Long> seatIds) {
        // Fetch the Booking entity
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + bookingId));

        // Fetch the User entity
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        // Validate seat count matches passenger count
        if (passengers.size() != seatIds.size()) {
            throw new IllegalArgumentException("The number of seats must match the number of passengers.");
        }

        // Set the User, Booking, and Seat for each passenger
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            Long seatId = seatIds.get(i);

            // Fetch the Seat entity
            Seat seat = seatRepository.findById(seatId)
                    .orElseThrow(() -> new EntityNotFoundException("Seat not found with ID: " + seatId));

            // Validate that the seat belongs to the flight of the booking
            if (!seat.getFlight().equals(booking.getFlight())) {
                throw new IllegalArgumentException("Seat ID " + seatId + " does not belong to the flight of this booking.");
            }

            passenger.setBooking(booking);
            passenger.setUser(user);
            passenger.setSeat(seat); // Set the Seat for the passenger
        }

        return passengerRepository.saveAll(passengers);
    }

    @Override
    public List<Passenger> getPassengersByBookingId(Long bookingId) {
        return passengerRepository.findByBookingId(bookingId);
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new EntityNotFoundException("Passenger not found with ID: " + passengerId));
    }

    @Override
    public List<Passenger> getPassengersByUserId(Long userId) {
        // Fetch passengers based on the userId
        return passengerRepository.findByUserId(userId);
    }
}
