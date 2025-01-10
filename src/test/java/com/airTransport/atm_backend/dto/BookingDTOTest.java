package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingDTOTest {

    private BookingDTO bookingDTO;

    @BeforeEach
    void setUp() {
        bookingDTO = new BookingDTO(1L, "John Doe", "Flight 101",
                LocalDateTime.of(2025, 1, 10, 12, 0),
                LocalDateTime.of(2025, 1, 15, 8, 0),
                "Confirmed");
    }

    @AfterEach
    void tearDown() {
        bookingDTO = null;
    }

    @Test
    void getId() {
        assertEquals(1L, bookingDTO.getId());
    }

    @Test
    void setId() {
        bookingDTO.setId(2L);
        assertEquals(2L, bookingDTO.getId());
    }

    @Test
    void getPassengerName() {
        assertEquals("John Doe", bookingDTO.getPassengerName());
    }

    @Test
    void setPassengerName() {
        bookingDTO.setPassengerName("Jane Doe");
        assertEquals("Jane Doe", bookingDTO.getPassengerName());
    }

    @Test
    void getFlightName() {
        assertEquals("Flight 101", bookingDTO.getFlightName());
    }

    @Test
    void setFlightName() {
        bookingDTO.setFlightName("Flight 102");
        assertEquals("Flight 102", bookingDTO.getFlightName());
    }

    @Test
    void getBookingDate() {
        assertEquals(LocalDateTime.of(2025, 1, 10, 12, 0), bookingDTO.getBookingDate());
    }

    @Test
    void setBookingDate() {
        LocalDateTime newBookingDate = LocalDateTime.of(2025, 1, 11, 10, 0);
        bookingDTO.setBookingDate(newBookingDate);
        assertEquals(newBookingDate, bookingDTO.getBookingDate());
    }

    @Test
    void getTravelDate() {
        assertEquals(LocalDateTime.of(2025, 1, 15, 8, 0), bookingDTO.getTravelDate());
    }

    @Test
    void setTravelDate() {
        LocalDateTime newTravelDate = LocalDateTime.of(2025, 1, 16, 9, 0);
        bookingDTO.setTravelDate(newTravelDate);
        assertEquals(newTravelDate, bookingDTO.getTravelDate());
    }

    @Test
    void getStatus() {
        assertEquals("Confirmed", bookingDTO.getStatus());
    }

    @Test
    void setStatus() {
        bookingDTO.setStatus("Cancelled");
        assertEquals("Cancelled", bookingDTO.getStatus());
    }
}
