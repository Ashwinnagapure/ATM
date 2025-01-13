package com.airTransport.atm_backend.service.impl;

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
    private CharterRepository charterRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setTravelDate(bookingDTO.getTravelDate());
        booking.setStatus(bookingDTO.getStatus());

        if (bookingDTO.getFlightId() != null) {
            Flight flight = flightRepository.findById(bookingDTO.getFlightId())
                    .orElseThrow(() -> new NotFoundException("Flight not found with ID: " + bookingDTO.getFlightId()));
            booking.setFlight(flight);
        }

        if (bookingDTO.getCharterId() != null) {
            Charter charter = charterRepository.findById(bookingDTO.getCharterId())
                    .orElseThrow(() -> new NotFoundException("Charter not found with ID: " + bookingDTO.getCharterId()));
            booking.setCharter(charter);
        }

        if (bookingDTO.getPassengerIds() != null) {
            List<Passenger> passengers = passengerRepository.findAllById(bookingDTO.getPassengerIds());
            booking.setPassengers(passengers);
        }

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
