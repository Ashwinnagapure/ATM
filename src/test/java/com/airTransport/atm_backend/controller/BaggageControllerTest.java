package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.service.BaggageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BaggageControllerTest {

    @Mock
    private BaggageService baggageService;

    @InjectMocks
    private BaggageController baggageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBaggageByBookingId() {
        Long bookingId = 1L;

        // Mock the response from service
        List<BaggageDTO> mockBaggageList = new ArrayList<>();
        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setId(1L);
        baggageDTO.setWeight(20.0);
        baggageDTO.setBagCount(2);
        baggageDTO.setBookingId(bookingId);
        mockBaggageList.add(baggageDTO);

        when(baggageService.getBaggageByBookingId(bookingId)).thenReturn(mockBaggageList);

        // Call the controller method
        ResponseEntity<List<BaggageDTO>> response = baggageController.getBaggageByBookingId(bookingId);

        // Assertions
        assertNotNull(response);
        assertEquals(1, response.getBody().size());
        assertEquals(20.0, response.getBody().get(0).getWeight());
        assertEquals(2, response.getBody().get(0).getBagCount());
        verify(baggageService, times(1)).getBaggageByBookingId(bookingId);
    }

    @Test
    void testAddBaggageToBooking() {
        Long bookingId = 1L;

        // Mock the request and response
        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setWeight(25.0);
        baggageDTO.setBagCount(3);

        BaggageDTO mockResponse = new BaggageDTO();
        mockResponse.setId(1L);
        mockResponse.setWeight(25.0);
        mockResponse.setBagCount(3);
        mockResponse.setBookingId(bookingId);

        when(baggageService.addBaggageToBooking(bookingId, baggageDTO)).thenReturn(mockResponse);

        // Call the controller method
        ResponseEntity<BaggageDTO> response = baggageController.addBaggageToBooking(bookingId, baggageDTO);

        // Assertions
        assertNotNull(response);
        assertEquals(1L, response.getBody().getId());
        assertEquals(25.0, response.getBody().getWeight());
        assertEquals(3, response.getBody().getBagCount());
        assertEquals(bookingId, response.getBody().getBookingId());
        verify(baggageService, times(1)).addBaggageToBooking(bookingId, baggageDTO);
    }

    @Test
    void testUpdateBaggage() {
        Long baggageId = 1L;

        // Mock the request and response
        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setWeight(30.0);
        baggageDTO.setBagCount(1);

        BaggageDTO mockResponse = new BaggageDTO();
        mockResponse.setId(baggageId);
        mockResponse.setWeight(30.0);
        mockResponse.setBagCount(1);

        when(baggageService.updateBaggage(baggageId, baggageDTO)).thenReturn(mockResponse);

        // Call the controller method
        ResponseEntity<BaggageDTO> response = baggageController.updateBaggage(baggageId, baggageDTO);

        // Assertions
        assertNotNull(response);
        assertEquals(baggageId, response.getBody().getId());
        assertEquals(30.0, response.getBody().getWeight());
        assertEquals(1, response.getBody().getBagCount());
        verify(baggageService, times(1)).updateBaggage(baggageId, baggageDTO);
    }

    @Test
    void testDeleteBaggage() {
        Long baggageId = 1L;

        // No return value for void methods
        doNothing().when(baggageService).deleteBaggage(baggageId);

        // Call the controller method
        ResponseEntity<String> response = baggageController.deleteBaggage(baggageId);

        // Assertions
        assertNotNull(response);
        assertEquals("Baggage deleted successfully.", response.getBody());
        verify(baggageService, times(1)).deleteBaggage(baggageId);
    }
}