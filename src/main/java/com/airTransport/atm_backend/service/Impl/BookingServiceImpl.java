package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
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
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setBookingDate(updatedBooking.getBookingDate());
        existingBooking.setTravelDate(updatedBooking.getTravelDate());
        existingBooking.setStatus(updatedBooking.getStatus());
        existingBooking.setFlight(updatedBooking.getFlight());
        existingBooking.setCharter(updatedBooking.getCharter());
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}
