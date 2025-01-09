package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.service.BoardingPassService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class BoardingPassControllerTest {

    @Mock
    private BoardingPassService boardingPassService;

    @InjectMocks
    private BoardingPassController boardingPassController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Initialize MockMvc and ObjectMapper
        mockMvc = MockMvcBuilders.standaloneSetup(boardingPassController).build();
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() {
        // Clean up resources, if needed
    }

    @Test
    void getAllBoardingPasses() throws Exception {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setBoardingPassId(1L);
        boardingPass.setBoardingTime("10:00");
        boardingPass.setBoardingDate("2025-01-10");
        boardingPass.setBoardingGate("A1");
        boardingPass.setSeat("12A");

        // Mock the service method
        when(boardingPassService.getAllBoardingPasses()).thenReturn(Collections.singletonList(boardingPass));

        mockMvc.perform(get("/boardingPasses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].boardingPassId").value(1))
                .andExpect(jsonPath("$[0].boardingTime").value("10:00"))
                .andExpect(jsonPath("$[0].boardingGate").value("A1"))
                .andExpect(jsonPath("$[0].seat").value("12A"));

        verify(boardingPassService, times(1)).getAllBoardingPasses();
    }

    @Test
    void getBoardingPassById() throws Exception {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setBoardingPassId(1L);
        boardingPass.setBoardingTime("10:00");
        boardingPass.setBoardingDate("2025-01-10");
        boardingPass.setBoardingGate("A1");
        boardingPass.setSeat("12A");

        // Mock the service method
        when(boardingPassService.getBoardingPassById(1L)).thenReturn(boardingPass);

        mockMvc.perform(get("/boardingPasses/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.boardingPassId").value(1))
                .andExpect(jsonPath("$.boardingTime").value("10:00"))
                .andExpect(jsonPath("$.boardingGate").value("A1"))
                .andExpect(jsonPath("$.seat").value("12A"));

        verify(boardingPassService, times(1)).getBoardingPassById(1L);
    }

//    @Test
//    void createBoardingPass() throws Exception {
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setBoardingTime("10:00");
//        boardingPass.setBoardingDate("2025-01-10");
//        boardingPass.setBoardingGate("A1");
//        boardingPass.setSeat("12A");
//
//        BoardingPass createdBoardingPass = new BoardingPass();
//        createdBoardingPass.setBoardingPassId(1L);
//        createdBoardingPass.setBoardingTime("10:00");
//        createdBoardingPass.setBoardingDate("2025-01-10");
//        createdBoardingPass.setBoardingGate("A1");
//        createdBoardingPass.setSeat("12A");
//
//        // Mock the service method
//        when(boardingPassService.createBoardingPass(boardingPass)).thenReturn(createdBoardingPass);
//
//        mockMvc.perform(post("/boardingPasses")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(boardingPass)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.boardingPassId").value(1))
//                .andExpect(jsonPath("$.boardingTime").value("10:00"))
//                .andExpect(jsonPath("$.boardingGate").value("A1"))
//                .andExpect(jsonPath("$.seat").value("12A"));
//
//        verify(boardingPassService, times(1)).createBoardingPass(boardingPass);
//    }

//    @Test
//    void testCreateBoardingPassForPayment() throws Exception {
//        Long paymentId = 1L;
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setBoardingTime("10:00");
//        boardingPass.setBoardingDate("2025-01-10");
//        boardingPass.setBoardingGate("A1");
//        boardingPass.setSeat("12A");
//
//        BoardingPass createdBoardingPass = new BoardingPass();
//        createdBoardingPass.setBoardingPassId(1L);
//        createdBoardingPass.setBoardingTime("10:00");
//        createdBoardingPass.setBoardingDate("2025-01-10");
//        createdBoardingPass.setBoardingGate("A1");
//        createdBoardingPass.setSeat("12A");
//
//        // Mock the service method
//        when(boardingPassService.createBoardingPassForPayment(paymentId, boardingPass))
//                .thenReturn(createdBoardingPass);
//
//        mockMvc.perform(post("/boardingPasses/generate/{paymentId}", paymentId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(boardingPass)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.boardingPassId").value(1))
//                .andExpect(jsonPath("$.boardingTime").value("10:00"))
//                .andExpect(jsonPath("$.boardingGate").value("A1"))
//                .andExpect(jsonPath("$.seat").value("12A"));
//
//        verify(boardingPassService, times(1)).createBoardingPassForPayment(paymentId, boardingPass);
//    }

//    @Test
//    void updateBoardingPass() throws Exception {
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setBoardingPassId(1L);
//        boardingPass.setBoardingTime("10:00");
//        boardingPass.setBoardingDate("2025-01-10");
//        boardingPass.setBoardingGate("A1");
//        boardingPass.setSeat("12A");
//
//        BoardingPass updatedBoardingPass = new BoardingPass();
//        updatedBoardingPass.setBoardingPassId(1L);
//        updatedBoardingPass.setBoardingTime("12:00");
//        updatedBoardingPass.setBoardingDate("2025-01-11");
//        updatedBoardingPass.setBoardingGate("B1");
//        updatedBoardingPass.setSeat("14B");
//
//        // Mock the service method
//        when(boardingPassService.updateBoardingPass(1L, boardingPass)).thenReturn(updatedBoardingPass);
//
//        mockMvc.perform(put("/boardingPasses/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(boardingPass)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.boardingPassId").value(1))
//                .andExpect(jsonPath("$.boardingTime").value("12:00"))
//                .andExpect(jsonPath("$.boardingGate").value("B1"))
//                .andExpect(jsonPath("$.seat").value("14B"));
//
//        verify(boardingPassService, times(1)).updateBoardingPass(1L, boardingPass);
//    }

    @Test
    void deleteBoardingPass() throws Exception {
        Long id = 1L;

        // Mock the service method
        doNothing().when(boardingPassService).deleteBoardingPass(id);

        mockMvc.perform(delete("/boardingPasses/{id}", id))
                .andExpect(status().isNoContent());

        verify(boardingPassService, times(1)).deleteBoardingPass(id);
    }
}
