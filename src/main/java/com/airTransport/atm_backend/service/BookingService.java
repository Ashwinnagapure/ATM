package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();

    void deleteBooking(Long id);
}
