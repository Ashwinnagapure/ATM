package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.BoardingPass;

import java.util.List;

public interface BoardingPassService {
    BoardingPass generateBoardingPass(BoardingPass boardingPass);
    BoardingPass getBoardingPassById(Long id);
    List<BoardingPass> getAllBoardingPasses();
    BoardingPass updateBoardingPass(Long id, BoardingPass updatedBoardingPass);
    void deleteBoardingPass(Long id);
}
