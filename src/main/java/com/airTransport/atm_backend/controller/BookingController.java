package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Value("${CORS}")
    private String corsUrl;

    @Autowired
    private BookingService bookingService;

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingService.createBooking(bookingDTO);
        return ResponseEntity.ok(convertToDTO(booking));
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(convertToDTO(booking));
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings.stream().map(this::convertToDTO).toList());
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);
        return ResponseEntity.ok(bookings.stream().map(this::convertToDTO).toList());
    }

    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setTravellerCount(booking.getTravellerCount());
        if (booking.getFlight() != null) {
            bookingDTO.setFlightId(booking.getFlight().getFlightId());
        }
        // Add logic to include userId if the user is not null
        if (booking.getUser() != null) {
            bookingDTO.setUserId(booking.getUser().getId());
        }
        return bookingDTO;
    }
}
