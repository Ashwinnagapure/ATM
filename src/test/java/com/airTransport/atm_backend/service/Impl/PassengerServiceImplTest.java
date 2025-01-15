package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PassengerServiceImplTest {

    @InjectMocks
    private PassengerServiceImpl passengerService;

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPassenger() {
        Booking booking = new Booking();
        booking.setId(1L);

        Passenger passenger = new Passenger();
        passenger.setName("John Doe");
        passenger.setEmail("john@example.com");
        passenger.setPhone("1234567890");

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(passengerRepository.save(any(Passenger.class))).thenAnswer(i -> i.getArguments()[0]);


    }

    @Test
    void testAddPassenger_BookingNotFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());


    }

    @Test
    void testGetPassengersByBookingId() {
        Booking booking = new Booking();
        booking.setId(1L);

        Passenger passenger = new Passenger();
        passenger.setBooking(booking);
        passenger.setName("John Doe");

        when(bookingRepository.existsById(1L)).thenReturn(true);
        when(passengerRepository.findByBookingId(1L)).thenReturn(Collections.singletonList(passenger));

        List<Passenger> passengers = passengerService.getPassengersByBookingId(1L);

        assertEquals(1, passengers.size());
        assertEquals("John Doe", passengers.get(0).getName());
    }

    @Test
    void testGetPassengerById() {
        Passenger passenger = new Passenger();
        passenger.setId(1L);
        passenger.setName("John Doe");

        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));

        Passenger foundPassenger = passengerService.getPassengerById(1L);

        assertNotNull(foundPassenger);
        assertEquals("John Doe", foundPassenger.getName());
    }

//    @Test
//    void testDeletePassenger() {
//        when(passengerRepository.existsById(1L)).thenReturn(true);
//
//
//        verify(passengerRepository, times(1)).deleteById(1L);
//    }

    @Test
    void testDeletePassenger_NotFound() {
        when(passengerRepository.existsById(1L)).thenReturn(false);


    }
}
