/*
package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.PassengerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository; // Mocked repository

    @InjectMocks
    private PassengerServiceImpl passengerService;
    private AutoCloseable autoCloseable;

    private Passenger passenger; // Sample passenger object

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        // Initialize the passenger object
        passenger = new Passenger();
        passenger.setUserId(1L);
        passenger.setUsername("testUser");
        passenger.setEmail("test@example.com");
        passenger.setPassword("password123");
        passenger.setRole("USER");
    }

    @AfterEach
    void tearDown() throws Exception {
        if (autoCloseable != null) {
            autoCloseable.close();
        }
    }

    @Test
    void testAddPassenger() {
        // Given
        when(passengerRepository.save(passenger)).thenReturn(passenger);

        // When
        String result = passengerService.addPassenger(passenger);

        // Then
        verify(passengerRepository, times(1)).save(passenger);
        assertEquals("Passenger added successfully", result);
    }

    @Test
    void testGetPassengerById() {
        // Given
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));

        // When
        Passenger result = passengerService.getPassengerById(1L);

        // Then
        verify(passengerRepository, times(1)).findById(1L);
        assertEquals(passenger, result);
    }

    @Test
    void testGetAllPassengers() {
        // Given
        List<Passenger> passengers = Arrays.asList(
                passenger,
                new Passenger()
        );
        when(passengerRepository.findAll()).thenReturn(passengers);

        // When
        List<Passenger> result = passengerService.getAllPassengers();

        // Then
        verify(passengerRepository, times(1)).findAll();
        assertEquals(passengers, result);
    }

    @Test
    void testDeletePassenger() {
        // Given
        doNothing().when(passengerRepository).deleteById(1L);

        // When
        passengerService.deletePassenger(1L);

        // Then
        verify(passengerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdatePassenger() {
        // Given
        when(passengerRepository.save(passenger)).thenReturn(passenger);

        // When
        Passenger result = passengerService.updatePassenger(passenger);

        // Then
        verify(passengerRepository, times(1)).save(passenger);
        assertEquals(passenger, result);
    }
}

*/
