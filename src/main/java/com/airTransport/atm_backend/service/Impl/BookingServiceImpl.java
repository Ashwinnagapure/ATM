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

    @Override
    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();


        if (bookingDTO.getFlightId() != null) {
            Flight flight = flightRepository.findById(bookingDTO.getFlightId())
                    .orElseThrow(() -> new NotFoundException("Flight not found with ID: " + bookingDTO.getFlightId()));
            booking.setFlight(flight);
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
}
