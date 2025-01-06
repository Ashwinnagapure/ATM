package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BookingDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    boolean deleteBooking(Long id);
    BookingDTO createBooking(BookingDTO bookingDTO);

    @Transactional
    BookingDTO createBooking(BookingDTO bookingDTO, Long passengerId, Long flightId);

    @Transactional
    BookingDTO createCharterBooking(BookingDTO bookingDTO, Long passengerId, Long charterId);

    boolean confirmBooking(Long id);
}
