package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BookingRepository;
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
    @Transactional
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setPassengerName(bookingDTO.getPassengerName());
        booking.setFlightNumber(bookingDTO.getFlightNumber());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setTravelDate(bookingDTO.getTravelDate());
        booking.setStatus(bookingDTO.getStatus());
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
                booking.getPassengerName(),
                booking.getFlightNumber(),
                booking.getBookingDate(),
                booking.getTravelDate(),
                booking.getStatus()
        );
    }
}
