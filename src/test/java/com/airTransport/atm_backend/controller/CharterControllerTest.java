package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.CharterService;
import com.airTransport.atm_backend.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CharterControllerTest {

    @Mock
    private CharterService charterService;

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private CharterController charterController;

    private AutoCloseable closeable;
    private Charter charter;

//    @BeforeEach
//    void setUp() {
//        closeable = MockitoAnnotations.openMocks(this);
//        charter = new Charter();
//        charter.setCharterId(1L);
//        charter.setSource("CityA");
//        charter.setDestination("CityB");
//    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

//    @Test
//    void createCharter() {
//        when(charterService.saveCharter(any(Charter.class))).thenReturn(charter);
//
//        ResponseEntity<Charter> response = charterController.createCharter(charter);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(charter.getCharterId(), response.getBody().getCharterId());
//        verify(charterService, times(1)).saveCharter(any(Charter.class));
//    }

    @Test
    void getAllCharters() {
        when(charterService.getAllCharters()).thenReturn(Collections.singletonList(charter));

        ResponseEntity<List<Charter>> response = charterController.getAllCharters();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        verify(charterService, times(1)).getAllCharters();
    }

//    @Test
//    void getCharterById() {
//        when(charterService.getCharterById(anyLong())).thenReturn(charter);
//
//        ResponseEntity<Charter> response = charterController.getCharterById(1L);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(charter.getCharterId(), response.getBody().getCharterId());
//        verify(charterService, times(1)).getCharterById(1L);
//    }

//    @Test
//    void updateCharter() {
//        Charter updatedCharter = new Charter();
//        updatedCharter.setCharterId(1L);
//        updatedCharter.setSource("UpdatedCityA");
//
//        when(charterService.updateCharter(anyLong(), any(Charter.class))).thenReturn(updatedCharter);
//
//        ResponseEntity<Charter> response = charterController.updateCharter(1L, updatedCharter);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals("UpdatedCityA", response.getBody().getSource());
//        verify(charterService, times(1)).updateCharter(1L, updatedCharter);
//    }

    @Test
    void deleteCharter() {
        doNothing().when(charterService).deleteCharter(anyLong());

        ResponseEntity<Void> response = charterController.deleteCharter(1L);
        assertEquals(204, response.getStatusCodeValue());
        verify(charterService, times(1)).deleteCharter(1L);
    }

//    @Test
//    void getChartersByPassenger() {
//        when(charterService.getChartersByPassenger(anyLong())).thenReturn(Collections.singletonList(charter));
//
//        ResponseEntity<List<Charter>> response = charterController.getChartersByPassenger(1L);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(1, response.getBody().size());
//        verify(charterService, times(1)).getChartersByPassenger(1L);
//    }
//
//    @Test
//    void assignPassengerToCharter() {
//        Passenger passenger = new Passenger();
//        passenger.setId(1L);
//
//        when(charterService.getCharterById(anyLong())).thenReturn(charter);
//        when(passengerService.getPassengerById(anyLong())).thenReturn(passenger);
//        when(charterService.saveCharter(any(Charter.class))).thenReturn(charter);
//
//        String response = charterController.assignPassengerToCharter(1L, 1L);
//        assertEquals("Passenger assigned to charter successfully", response);
//        verify(charterService, times(1)).getCharterById(1L);
//        verify(passengerService, times(1)).getPassengerById(1L);
//        verify(charterService, times(1)).saveCharter(charter);
//    }
}
