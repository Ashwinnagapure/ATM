package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.BoardingPassRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardingPassServiceImplTest {

    @Mock
    private BoardingPassRepository boardingPassRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private BoardingPassServiceImpl boardingPassService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBoardingPasses() {
        BoardingPass boardingPass1 = new BoardingPass();
        boardingPass1.setBoardingPassId(1L);

        BoardingPass boardingPass2 = new BoardingPass();
        boardingPass2.setBoardingPassId(2L);

        when(boardingPassRepository.findAll()).thenReturn(Arrays.asList(boardingPass1, boardingPass2));

        List<BoardingPass> result = boardingPassService.getAllBoardingPasses();

        assertEquals(2, result.size());
        verify(boardingPassRepository, times(1)).findAll();
    }

    @Test
    void createBoardingPassForPayment() {
        Payment payment = new Payment();
        payment.setPaymentId(1L);

        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setSeat("12A");

        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(boardingPassRepository.save(boardingPass)).thenReturn(boardingPass);

        BoardingPass result = boardingPassService.createBoardingPassForPayment(1L, boardingPass);

        assertNotNull(result);
        assertEquals("12A", result.getSeat());
        verify(paymentRepository, times(1)).findById(1L);
        verify(boardingPassRepository, times(1)).save(boardingPass);
    }

    @Test
    void getBoardingPassById() {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setBoardingPassId(1L);

        when(boardingPassRepository.findById(1L)).thenReturn(Optional.of(boardingPass));

        BoardingPass result = boardingPassService.getBoardingPassById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getBoardingPassId());
        verify(boardingPassRepository, times(1)).findById(1L);
    }

    @Test
    void createBoardingPass() {
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setSeat("15B");

        when(boardingPassRepository.save(boardingPass)).thenReturn(boardingPass);

        BoardingPass result = boardingPassService.createBoardingPass(boardingPass);

        assertNotNull(result);
        assertEquals("15B", result.getSeat());
        verify(boardingPassRepository, times(1)).save(boardingPass);
    }

    @Test
    void updateBoardingPass() {
        BoardingPass existingBoardingPass = new BoardingPass();
        existingBoardingPass.setBoardingPassId(1L);

        BoardingPass updatedBoardingPass = new BoardingPass();
        updatedBoardingPass.setBoardingTime("12:00 PM");
        updatedBoardingPass.setBoardingDate("2023-01-01");
        updatedBoardingPass.setSeat("10A");

        when(boardingPassRepository.findById(1L)).thenReturn(Optional.of(existingBoardingPass));
        when(boardingPassRepository.save(existingBoardingPass)).thenReturn(existingBoardingPass);

        BoardingPass result = boardingPassService.updateBoardingPass(1L, updatedBoardingPass);

        assertNotNull(result);
        assertEquals("12:00 PM", result.getBoardingTime());
        assertEquals("2023-01-01", result.getBoardingDate());
        assertEquals("10A", result.getSeat());
        verify(boardingPassRepository, times(1)).findById(1L);
        verify(boardingPassRepository, times(1)).save(existingBoardingPass);
    }

    @Test
    void deleteBoardingPass() {
        doNothing().when(boardingPassRepository).deleteById(1L);

        boardingPassService.deleteBoardingPass(1L);

        verify(boardingPassRepository, times(1)).deleteById(1L);
    }
}