package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PassengerDTO;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.PassengerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PassengerController.class)
public class PassengerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PassengerService passengerService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
//
//    @Test
//    void testAddPassenger() throws Exception {
//        PassengerDTO passengerDTO = new PassengerDTO();
//        passengerDTO.setName("John Doe");
//        passengerDTO.setEmail("john@example.com");
//        passengerDTO.setPhone("1234567890");
//
//        Passenger passenger = new Passenger();
//        passenger.setName("John Doe");
//
//        when(passengerService.addPassenger(any(Passenger.class), eq(1L))).thenReturn(passenger);
//
//        mockMvc.perform(post("/passengers/1")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(passengerDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    void testGetPassengersByBookingId() throws Exception {
//        Passenger passenger = new Passenger();
//        passenger.setName("John Doe");
//
//        when(passengerService.getPassengersByBookingId(1L)).thenReturn(Collections.singletonList(passenger));
//
//        mockMvc.perform(get("/passengers/booking/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("John Doe"));
//    }
}
