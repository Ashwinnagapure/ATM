package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    private Booking booking;
    private BookingDTO bookingDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        booking = new Booking();
        booking.setId(1L);
        booking.setTravellerCount(2);

        bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setTravellerCount(2);
    }

//    @Test
//    void testCreateBooking() {
//        when(bookingService.createBooking(any(BookingDTO.class))).thenReturn(booking);
//
//        ResponseEntity<BookingDTO> response = bookingController.createBooking(bookingDTO);
//
//        assertNotNull(response.getBody());
//        assertEquals(1L, response.getBody().getId());
//        assertEquals(2, response.getBody().getTravellerCount());
//        verify(bookingService, times(1)).createBooking(any(BookingDTO.class));
//    }

    @Test
    void testGetBookingById() {
        when(bookingService.getBookingById(1L)).thenReturn(booking);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(bookingService, times(1)).getBookingById(1L);
    }

    @Test
    void testGetAllBookings() {
        when(bookingService.getAllBookings()).thenReturn(Arrays.asList(booking));

        ResponseEntity<List<BookingDTO>> response = bookingController.getAllBookings();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(1L, response.getBody().get(0).getId());
        verify(bookingService, times(1)).getAllBookings();
    }

//    @Test
//    void testDeleteBooking() {
//        doNothing().when(bookingService).deleteBooking(1L);
//
//        ResponseEntity<Void> response = bookingController.deleteBooking(1L);
//
//        assertEquals(204, response.getStatusCodeValue());
//        verify(bookingService, times(1)).deleteBooking(1L);
//    }
}