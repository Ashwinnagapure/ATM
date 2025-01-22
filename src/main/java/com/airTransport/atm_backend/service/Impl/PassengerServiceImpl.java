package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.EntityNotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
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

    @Override
    public List<Passenger> addPassengersToBooking(List<Passenger> passengers, Long bookingId, Long userId) {
        // Fetch the Booking entity
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + bookingId));

        // Fetch the User entity
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        // Set the User and Booking for each passenger
        passengers.forEach(passenger -> {
            passenger.setBooking(booking);
            passenger.setUser(user);
        });

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


