package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.enums.VehicleType;
import com.airTransport.atm_backend.repository.CharterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharterServiceImplTest {

    @Mock
    private CharterRepository charterRepository;

    @InjectMocks
    private CharterServiceImpl charterService;

    private Charter charter;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        passenger = new Passenger();
        passenger.setId(1L);
        passenger.setUsername("John Doe");

        charter = new Charter();
        charter.setCharterId(1L);
        charter.setVehicleType(VehicleType.PRIVATE_JET);
        charter.setSource("New York");
        charter.setDestination("Los Angeles");
        charter.setDeparture(LocalDateTime.now());
        charter.setArrival(LocalDateTime.now().plusHours(5));
        charter.setPassenger(passenger);
    }

    @AfterEach
    void tearDown() {
        passenger = null;
        charter = null;
    }

    @Test
    void saveCharter() {
        when(charterRepository.save(any(Charter.class))).thenReturn(charter);

        Charter savedCharter = charterService.saveCharter(charter);

        assertNotNull(savedCharter);
        assertEquals(1L, savedCharter.getCharterId());
        assertEquals("New York", savedCharter.getSource());
        verify(charterRepository, times(1)).save(charter);
    }

    @Test
    void getAllCharters() {
        when(charterRepository.findAll()).thenReturn(Arrays.asList(charter));

        List<Charter> charters = charterService.getAllCharters();

        assertNotNull(charters);
        assertEquals(1, charters.size());
        assertEquals("New York", charters.get(0).getSource());
        verify(charterRepository, times(1)).findAll();
    }

    @Test
    void getCharterById() {
        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));

        Charter foundCharter = charterService.getCharterById(1L);

        assertNotNull(foundCharter);
        assertEquals(1L, foundCharter.getCharterId());
        verify(charterRepository, times(1)).findById(1L);
    }

    @Test
    void getCharterById_CharterNotFound() {
        when(charterRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            charterService.getCharterById(1L);
        });

        assertEquals("Charter not found with ID: 1", exception.getMessage());
        verify(charterRepository, times(1)).findById(1L);
    }

    @Test
    void updateCharter() {
        Charter updatedCharter = new Charter();
        updatedCharter.setVehicleType(VehicleType.HELICOPTER);
        updatedCharter.setSource("San Francisco");
        updatedCharter.setDestination("Seattle");

        when(charterRepository.findById(1L)).thenReturn(Optional.of(charter));
        when(charterRepository.save(any(Charter.class))).thenReturn(updatedCharter);

        Charter result = charterService.updateCharter(1L, updatedCharter);

        assertNotNull(result);
        assertEquals(VehicleType.HELICOPTER, result.getVehicleType());
        assertEquals("San Francisco", result.getSource());
        verify(charterRepository, times(1)).save(any(Charter.class));
    }

    @Test
    void deleteCharter() {
        doNothing().when(charterRepository).deleteById(1L);

        charterService.deleteCharter(1L);

        verify(charterRepository, times(1)).deleteById(1L);
    }

//    @Test
//    void getChartersByPassenger() {
//        when(passenger.getId(1L)).thenReturn(passenger.getId(1L));
//        when(charterRepository.findByPassenger(passenger)).thenReturn(Collections.singletonList(charter));
//
//        List<Charter> charters = charterService.getChartersByPassenger(passenger.getUserId());
//
//        assertNotNull(charters);
//        assertEquals(1, charters.size());
//        assertEquals("New York", charters.get(0).getSource());
//        verify(passenger, times(1)).getId(1L);
//        verify(charterRepository, times(1)).findByPassenger(passenger);
//    }
}