//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.BookingDTO;
//import com.airTransport.atm_backend.model.Booking;
//import com.airTransport.atm_backend.service.BookingService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BookingController.class)
//public class BookingControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookingService bookingService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private BookingDTO bookingDTO;
//    private Booking booking;
//
//    @BeforeEach
//    void setUp() {
//        bookingDTO = new BookingDTO();
//        bookingDTO.setId(1L);
//        bookingDTO.setFlightId(100L);
//        bookingDTO.setTravellerCount(2);
//
//        booking = new Booking();
//        booking.setId(1L);
//        booking.setTravellerCount(2);
//    }
//
//    @Test
//    void testCreateBooking() throws Exception {
//        Mockito.when(bookingService.createBooking(any(BookingDTO.class))).thenReturn(booking);
//
//        mockMvc.perform(post("/bookings")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookingDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.travellerCount").value(2));
//    }
//
//    @Test
//    void testGetBookingById() throws Exception {
//        Mockito.when(bookingService.getBookingById(1L)).thenReturn(booking);
//
//        mockMvc.perform(get("/bookings/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.travellerCount").value(2));
//    }
//
//    @Test
//    void testGetAllBookings() throws Exception {
//        List<Booking> bookings = Arrays.asList(booking);
//        Mockito.when(bookingService.getAllBookings()).thenReturn(bookings);
//
//        mockMvc.perform(get("/bookings")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].travellerCount").value(2));
//    }
//
//    @Test
//    void testDeleteBooking() throws Exception {
//        Mockito.doNothing().when(bookingService).deleteBooking(1L);
//
//        mockMvc.perform(delete("/bookings/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//}
