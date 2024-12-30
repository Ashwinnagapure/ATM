package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    boolean deleteBooking(Long id);
    BookingDTO createBooking(BookingDTO bookingDTO);
    boolean confirmBooking(Long id);
}
