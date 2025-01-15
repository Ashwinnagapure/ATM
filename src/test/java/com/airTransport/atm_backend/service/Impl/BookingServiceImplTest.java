package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BookingDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Flight flight;
    private Booking booking;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize data
        flight = new Flight();
        flight.setDeparture(LocalDateTime.parse("2025-01-15T10:00"));
        flight.setArrival(LocalDateTime.parse("2025-01-15T12:00"));

        booking = new Booking();
        booking.setTravellerCount(2);
        booking.setFlight(flight);
    }

    @Test
    public void testCreateBooking() {
        // Mocking the repository calls
        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flight));

        // Set an ID for the Booking mock before returning it
        Booking booking = new Booking();
        booking.setId(1L); // Set a valid ID here
        booking.setTravellerCount(2);  // Ensure travellerCount is set

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setFlightId(1L);
        bookingDTO.setTravellerCount(2); // Set traveller count in the DTO

        Booking createdBooking = bookingService.createBooking(bookingDTO);

        // Assert that the ID is not null
        assertNotNull(createdBooking.getId(), "Booking should be saved with an ID.");
        assertEquals(2, createdBooking.getTravellerCount(), "Traveller count should match.");
    }



    @Test
    public void testGetBookingById_NotFound() {
        when(bookingRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> bookingService.getBookingById(1L), "Booking not found exception should be thrown.");
    }
}