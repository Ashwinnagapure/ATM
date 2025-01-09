//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.model.Charter;
//import com.airTransport.atm_backend.model.Passenger;
//import com.airTransport.atm_backend.service.CharterService;
//import com.airTransport.atm_backend.service.PassengerService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(CharterController.class)
//class CharterControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private CharterService charterService;
//
//    @Mock
//    private PassengerService passengerService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Charter charter;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        charter = new Charter();
//        charter.setCharterId(1L);
//        charter.setSource("City A");
//        charter.setDestination("City B");
//        charter.setDeparture(LocalDateTime.of(2025, 1, 10, 10, 30));
//        charter.setArrival(LocalDateTime.of(2025, 1, 10, 14, 30));
//    }
//
////    @Test
////    void createCharter() throws Exception {
////        when(charterService.saveCharter(any(Charter.class))).thenReturn(charter);
////
////        mockMvc.perform(post("/charters")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(charter)))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.source").value("City A"))
////                .andExpect(jsonPath("$.destination").value("City B"));
////
////        verify(charterService, times(1)).saveCharter(any(Charter.class));
////    }
////
////    @Test
////    void getAllCharters() throws Exception {
////        List<Charter> charters = Arrays.asList(charter);
////        when(charterService.getAllCharters()).thenReturn(charters);
////
////        mockMvc.perform(get("/charters"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].source").value("City A"));
////
////        verify(charterService, times(1)).getAllCharters();
////    }
////
////    @Test
////    void getCharterById() throws Exception {
////        when(charterService.getCharterById(1L)).thenReturn(charter);
////
////        mockMvc.perform(get("/charters/1"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.source").value("City A"));
////
////        verify(charterService, times(1)).getCharterById(1L);
////    }
////
////    @Test
////    void updateCharter() throws Exception {
////        Charter updatedCharter = new Charter();
////        updatedCharter.setCharterId(1L);
////        updatedCharter.setSource("City X");
////        updatedCharter.setDestination("City Y");
////        when(charterService.updateCharter(eq(1L), any(Charter.class))).thenReturn(updatedCharter);
////
////        mockMvc.perform(put("/charters/1")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(updatedCharter)))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.source").value("City X"));
////
////        verify(charterService, times(1)).updateCharter(eq(1L), any(Charter.class));
////    }
////
////    @Test
////    void deleteCharter() throws Exception {
////        doNothing().when(charterService).deleteCharter(1L);
////
////        mockMvc.perform(delete("/charters/1"))
////                .andExpect(status().isNoContent());
////
////        verify(charterService, times(1)).deleteCharter(1L);
////    }
////
////    @Test
////    void getChartersByPassenger() throws Exception {
////        when(charterService.getChartersByPassenger(1L)).thenReturn(Arrays.asList(charter));
////
////        mockMvc.perform(get("/charters/passenger/1"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].source").value("City A"));
////
////        verify(charterService, times(1)).getChartersByPassenger(1L);
////    }
////
////    @Test
////    void assignPassengerToCharter() throws Exception {
////        Passenger passenger = new Passenger();
////        passenger.setId(1L);
////
////        when(charterService.getCharterById(1L)).thenReturn(charter);
////        when(passengerService.getPassengerById(1L)).thenReturn(passenger);
////        when(charterService.saveCharter(any(Charter.class))).thenReturn(charter);
////
////        mockMvc.perform(post("/charters/assign-passenger/1/1"))
////                .andExpect(status().isOk())
////                .andExpect(content().string("Passenger assigned to charter successfully"));
////
////        verify(charterService, times(1)).getCharterById(1L);
////        verify(passengerService, times(1)).getPassengerById(1L);
////        verify(charterService, times(1)).saveCharter(any(Charter.class));
////    }
//}
