package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BoardingPassDTO;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardingPassControllerTest {

    @InjectMocks
    private BoardingPassController boardingPassController;

    @Mock
    private BoardingPassService boardingPassService;

    public BoardingPassControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateBoardingPass() {
        BoardingPassDTO boardingPassDTO = new BoardingPassDTO();
        boardingPassDTO.setGate("A1");
        boardingPassDTO.setSeatNumber("12B");
        boardingPassDTO.setBookingId(1L);

        when(boardingPassService.generateBoardingPass(any(BoardingPassDTO.class))).thenReturn(boardingPassDTO);

        ResponseEntity<BoardingPassDTO> response = boardingPassController.generateBoardingPass(boardingPassDTO);

        assertNotNull(response);
        assertEquals("A1", response.getBody().getGate());
        verify(boardingPassService, times(1)).generateBoardingPass(any(BoardingPassDTO.class));
    }

    @Test
    void testGetBoardingPassById() {
        BoardingPassDTO boardingPassDTO = new BoardingPassDTO();
        boardingPassDTO.setId(1L);
        boardingPassDTO.setGate("A1");

        when(boardingPassService.getBoardingPassById(1L)).thenReturn(boardingPassDTO);

        ResponseEntity<BoardingPassDTO> response = boardingPassController.getBoardingPassById(1L);

        assertNotNull(response);
        assertEquals(1L, response.getBody().getId());
        verify(boardingPassService, times(1)).getBoardingPassById(1L);
    }

    @Test
    void testGetAllBoardingPasses() {
        BoardingPassDTO pass1 = new BoardingPassDTO();
        pass1.setId(1L);

        BoardingPassDTO pass2 = new BoardingPassDTO();
        pass2.setId(2L);

        when(boardingPassService.getAllBoardingPasses()).thenReturn(Arrays.asList(pass1, pass2));

        ResponseEntity<List<BoardingPassDTO>> response = boardingPassController.getAllBoardingPasses();

        assertNotNull(response);
        assertEquals(2, response.getBody().size());
        verify(boardingPassService, times(1)).getAllBoardingPasses();
    }

    @Test
    void testUpdateBoardingPass() {
        BoardingPassDTO updatedDTO = new BoardingPassDTO();
        updatedDTO.setId(1L);
        updatedDTO.setGate("B2");

        when(boardingPassService.updateBoardingPass(eq(1L), any(BoardingPassDTO.class))).thenReturn(updatedDTO);

        ResponseEntity<BoardingPassDTO> response = boardingPassController.updateBoardingPass(1L, updatedDTO);

        assertNotNull(response);
        assertEquals("B2", response.getBody().getGate());
        verify(boardingPassService, times(1)).updateBoardingPass(eq(1L), any(BoardingPassDTO.class));
    }

    @Test
    void testDeleteBoardingPass() {
        doNothing().when(boardingPassService).deleteBoardingPass(1L);

        ResponseEntity<Void> response = boardingPassController.deleteBoardingPass(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(boardingPassService, times(1)).deleteBoardingPass(1L);
    }
}
