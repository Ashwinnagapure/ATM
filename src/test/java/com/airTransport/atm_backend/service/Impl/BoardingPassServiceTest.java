package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BoardingPassDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BoardingPassRepository;
import com.airTransport.atm_backend.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardingPassServiceTest {

    @InjectMocks
    private BoardingPassServiceImpl boardingPassService;

    @Mock
    private BoardingPassRepository boardingPassRepository;

    @Mock
    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testGenerateBoardingPass() {
//        BoardingPassDTO dto = new BoardingPassDTO();
//        dto.setGate("A1");
//        dto.setSeatNumber("10A");
//        dto.setBookingId(1L);
//
//        Booking booking = new Booking();
//        booking.setId(1L);
//
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setId(1L);
//
//        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
//        when(boardingPassRepository.save(any(BoardingPass.class))).thenReturn(boardingPass);
//
//        BoardingPassDTO result = boardingPassService.generateBoardingPass(dto);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(bookingRepository, times(1)).findById(1L);
//        verify(boardingPassRepository, times(1)).save(any(BoardingPass.class));
//    }
//
//    @Test
//    void testGetBoardingPassById() {
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setId(1L);
//
//        when(boardingPassRepository.findById(1L)).thenReturn(Optional.of(boardingPass));
//
//        BoardingPassDTO result = boardingPassService.getBoardingPassById(1L);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(boardingPassRepository, times(1)).findById(1L);
//    }

    @Test
    void testDeleteBoardingPass() {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setId(1L);

        when(boardingPassRepository.findById(1L)).thenReturn(Optional.of(boardingPass));
        doNothing().when(boardingPassRepository).delete(boardingPass);

        boardingPassService.deleteBoardingPass(1L);

        verify(boardingPassRepository, times(1)).delete(boardingPass);
    }

    @Test
    void testNotFoundException() {
        when(boardingPassRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> boardingPassService.getBoardingPassById(1L));
    }
}
