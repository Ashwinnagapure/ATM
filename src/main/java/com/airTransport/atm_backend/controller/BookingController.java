package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO booking = bookingService.getBookingById(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingService.deleteBooking(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{passengerId}/flight/{flightId}")
    public ResponseEntity<BookingDTO> createFlightBooking(@RequestBody BookingDTO bookingDTO,
                                                          @PathVariable Long passengerId,
                                                          @PathVariable Long flightId) {
        BookingDTO createdBooking = bookingService.createBooking(bookingDTO, passengerId, flightId);
        return ResponseEntity.ok(createdBooking);
    }

    @PostMapping("/{passengerId}/charter/{charterId}")
    public ResponseEntity<BookingDTO> createCharterBooking(@RequestBody BookingDTO bookingDTO,
                                                           @PathVariable Long passengerId,
                                                           @PathVariable Long charterId) {
        BookingDTO createdBooking = bookingService.createCharterBooking(bookingDTO, passengerId, charterId);
        return ResponseEntity.ok(createdBooking);
    }
    @PutMapping("/{id}/confirm")
    public ResponseEntity<Void> confirmBooking(@PathVariable Long id) {
        if (bookingService.confirmBooking(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
