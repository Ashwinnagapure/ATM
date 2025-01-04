package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.CharterRepository;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CharterRepository charterRepository;

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        return bookingOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return null;
    }


    @Transactional
    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO, Long passengerId, Long flightId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Booking booking = new Booking();
        booking.setPassenger(passenger);
        booking.setFlight(flight);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setTravelDate(bookingDTO.getTravelDate());
        booking.setStatus("PENDING");

        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    @Override
    public BookingDTO createCharterBooking(BookingDTO bookingDTO, Long passengerId, Long charterId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        Charter charter = charterRepository.findById(charterId)
                .orElseThrow(() -> new RuntimeException("Charter not found"));

        Booking booking = new Booking();
        booking.setPassenger(passenger);
        booking.setCharter(charter);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setTravelDate(bookingDTO.getTravelDate());
        booking.setStatus("PENDING");

        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    @Override
    @Transactional
    public boolean confirmBooking(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus("CONFIRMED");
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

    private BookingDTO convertToDTO(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getPassenger().getUsername(),
                booking.getFlight() != null ? booking.getFlight().getFlightName() : "Charter Booking",
                booking.getBookingDate(),
                booking.getTravelDate(),
                booking.getStatus()
        );
    }
}
