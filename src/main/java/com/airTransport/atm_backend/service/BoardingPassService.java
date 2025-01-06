package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.BoardingPass;

import java.util.List;

public interface BoardingPassService {
    List<BoardingPass> getAllBoardingPasses();

    BoardingPass createBoardingPassForPayment(Long paymentId, BoardingPass boardingPass);

    BoardingPass getBoardingPassById(Long id);
    BoardingPass createBoardingPass(BoardingPass boardingPass);
    BoardingPass updateBoardingPass(Long id, BoardingPass boardingPass);
    void deleteBoardingPass(Long id);
}
