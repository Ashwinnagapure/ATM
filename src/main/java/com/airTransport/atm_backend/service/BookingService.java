package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingDTO bookingDTO);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    void deleteBooking(Long id);

    // New method to fetch bookings by user ID
    List<Booking> getBookingsByUserId(Long userId);
}
