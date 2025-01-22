package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.*;
import com.airTransport.atm_backend.repository.*;
import com.airTransport.atm_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private UserRepository userRepository;  // Inject UserRepository

    @Override
    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();

        // Fetch flight and user based on provided IDs
        if (bookingDTO.getFlightId() != null) {
            Flight flight = flightRepository.findById(bookingDTO.getFlightId())
                    .orElseThrow(() -> new NotFoundException("Flight not found with ID: " + bookingDTO.getFlightId()));
            booking.setFlight(flight);
        }

        if (bookingDTO.getUserId() != null) {
            User user = userRepository.findById(bookingDTO.getUserId())
                    .orElseThrow(() -> new NotFoundException("User not found with ID: " + bookingDTO.getUserId()));
            booking.setUser(user);  // Set the user to the booking
        }

        booking.setTravellerCount(bookingDTO.getTravellerCount());

        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found with ID: " + id));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    // New method to fetch bookings by user ID
    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);

        if (bookings.isEmpty()) {
            throw new NotFoundException("No bookings found for user with ID: " + userId);
        }

        return bookings;
    }
}
