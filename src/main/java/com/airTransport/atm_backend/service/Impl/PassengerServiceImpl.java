package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
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

    @Override
    public Passenger addPassenger(Passenger passenger, Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException("Booking not found with ID: " + bookingId));
        passenger.setBooking(booking);
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getPassengersByBookingId(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new NotFoundException("Booking not found with ID: " + bookingId);
        }
        return passengerRepository.findByBookingId(bookingId);
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new NotFoundException("Passenger not found with ID: " + passengerId));
    }

    @Override
    public Passenger updatePassenger(Long passengerId, Passenger passengerDetails) {
        Passenger passenger = getPassengerById(passengerId);
        passenger.setName(passengerDetails.getName());
        passenger.setEmail(passengerDetails.getEmail());
        passenger.setPhone(passengerDetails.getPhone());
        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        if (!passengerRepository.existsById(passengerId)) {
            throw new NotFoundException("Passenger not found with ID: " + passengerId);
        }
        passengerRepository.deleteById(passengerId);
    }
}
