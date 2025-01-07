package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBookings_Success() {
        List<BookingDTO> mockBookings = Arrays.asList(
                new BookingDTO(1L, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Confirmed"),
                new BookingDTO(2L, "Jane", "Charter", LocalDateTime.now(), LocalDateTime.now().plusDays(2), "Pending")
        );
        when(bookingService.getAllBookings()).thenReturn(mockBookings);

        ResponseEntity<List<BookingDTO>> response = bookingController.getAllBookings();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(bookingService, times(1)).getAllBookings();
    }

    @Test
    void testGetAllBookings_EmptyDatabase() {
        when(bookingService.getAllBookings()).thenReturn(Collections.emptyList());

        ResponseEntity<List<BookingDTO>> response = bookingController.getAllBookings();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
        verify(bookingService, times(1)).getAllBookings();
    }

    @Test
    void testGetAllBookings_LargeDataset() {
        List<BookingDTO> mockBookings = Arrays.asList(
                new BookingDTO(1L, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Confirmed"),
                new BookingDTO(2L, "Jane", "Charter", LocalDateTime.now(), LocalDateTime.now().plusDays(2), "Pending")
                // Add more entries to simulate a large dataset if necessary
        );
        when(bookingService.getAllBookings()).thenReturn(mockBookings);

        ResponseEntity<List<BookingDTO>> response = bookingController.getAllBookings();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockBookings.size(), response.getBody().size());
        verify(bookingService, times(1)).getAllBookings();
    }

    @Test
    void testGetBookingById_Found() {
        BookingDTO mockBooking = new BookingDTO(1L, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Confirmed");
        when(bookingService.getBookingById(1L)).thenReturn(mockBooking);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockBooking, response.getBody());
        verify(bookingService, times(1)).getBookingById(1L);
    }

    @Test
    void testGetBookingById_NotFound() {
        when(bookingService.getBookingById(1L)).thenReturn(null);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(1L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(bookingService, times(1)).getBookingById(1L);
    }

    @Test
    void testGetBookingById_ValidId() {
        BookingDTO mockBooking = new BookingDTO(1L, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Confirmed");
        when(bookingService.getBookingById(1L)).thenReturn(mockBooking);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockBooking, response.getBody());
        verify(bookingService, times(1)).getBookingById(1L);
    }

    @Test
    void testGetBookingById_NonExistentId() {
        when(bookingService.getBookingById(999L)).thenReturn(null);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(999L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(bookingService, times(1)).getBookingById(999L);
    }

    @Test
    void testGetBookingById_BoundaryId() {
        when(bookingService.getBookingById(Long.MAX_VALUE)).thenReturn(null);

        ResponseEntity<BookingDTO> response = bookingController.getBookingById(Long.MAX_VALUE);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(bookingService, times(1)).getBookingById(Long.MAX_VALUE);
    }

    @Test
    void testDeleteBooking_Success() {
        when(bookingService.deleteBooking(1L)).thenReturn(true);

        ResponseEntity<Void> response = bookingController.deleteBooking(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(bookingService, times(1)).deleteBooking(1L);
    }

    @Test
    void testDeleteBooking_NotFound() {
        when(bookingService.deleteBooking(1L)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.deleteBooking(1L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).deleteBooking(1L);
    }


    @Test
    void testDeleteBooking_ValidId() {
        when(bookingService.deleteBooking(1L)).thenReturn(true);

        ResponseEntity<Void> response = bookingController.deleteBooking(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(bookingService, times(1)).deleteBooking(1L);
    }

    @Test
    void testDeleteBooking_NonExistentId() {
        when(bookingService.deleteBooking(999L)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.deleteBooking(999L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).deleteBooking(999L);
    }

    @Test
    void testDeleteBooking_BoundaryId() {
        when(bookingService.deleteBooking(Long.MIN_VALUE)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.deleteBooking(Long.MIN_VALUE);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).deleteBooking(Long.MIN_VALUE);
    }

    @Test
    void testCreateFlightBooking_Success() {
        BookingDTO inputBooking = new BookingDTO(null, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Pending");
        BookingDTO createdBooking = new BookingDTO(1L, "John", "Flight", LocalDateTime.now(), LocalDateTime.now().plusDays(1), "Confirmed");
        when(bookingService.createBooking(inputBooking, 1L, 2L)).thenReturn(createdBooking);

        ResponseEntity<BookingDTO> response = bookingController.createFlightBooking(inputBooking, 1L, 2L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(createdBooking, response.getBody());
        verify(bookingService, times(1)).createBooking(inputBooking, 1L, 2L);
    }

    @Test
    void testCreateFlightBooking_NullInput() {
        when(bookingService.createBooking(null, 1L, 2L)).thenThrow(new IllegalArgumentException("Booking cannot be null"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                bookingController.createFlightBooking(null, 1L, 2L)
        );

        assertEquals("Booking cannot be null", exception.getMessage());
        verify(bookingService, times(1)).createBooking(null, 1L, 2L);
    }

    @Test
    void testCreateCharterBooking_Success() {
        BookingDTO inputBooking = new BookingDTO(null, "Jane", "Charter", LocalDateTime.now(), LocalDateTime.now().plusDays(2), "Pending");
        BookingDTO createdBooking = new BookingDTO(2L, "Jane", "Charter", LocalDateTime.now(), LocalDateTime.now().plusDays(2), "Confirmed");
        when(bookingService.createCharterBooking(inputBooking, 1L, 2L)).thenReturn(createdBooking);

        ResponseEntity<BookingDTO> response = bookingController.createCharterBooking(inputBooking, 1L, 2L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(createdBooking, response.getBody());
        verify(bookingService, times(1)).createCharterBooking(inputBooking, 1L, 2L);
    }

    @Test
    void testConfirmBooking_Success() {
        when(bookingService.confirmBooking(1L)).thenReturn(true);

        ResponseEntity<Void> response = bookingController.confirmBooking(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(bookingService, times(1)).confirmBooking(1L);
    }

    @Test
    void testConfirmBooking_NotFound() {
        when(bookingService.confirmBooking(1L)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.confirmBooking(1L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).confirmBooking(1L);
    }

    @Test
    void testConfirmBooking_BoundaryId() {
        when(bookingService.confirmBooking(Long.MAX_VALUE)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.confirmBooking(Long.MAX_VALUE);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).confirmBooking(Long.MAX_VALUE);
    }

    @Test
    void testConfirmBooking_ValidId() {
        when(bookingService.confirmBooking(1L)).thenReturn(true);

        ResponseEntity<Void> response = bookingController.confirmBooking(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(bookingService, times(1)).confirmBooking(1L);
    }

    @Test
    void testConfirmBooking_NonExistentId() {
        when(bookingService.confirmBooking(999L)).thenReturn(false);

        ResponseEntity<Void> response = bookingController.confirmBooking(999L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(bookingService, times(1)).confirmBooking(999L);
    }
}
