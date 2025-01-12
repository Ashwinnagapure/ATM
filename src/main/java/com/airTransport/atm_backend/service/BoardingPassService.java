package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.BoardingPassDTO;

import java.util.List;

public interface BoardingPassService {
    BoardingPassDTO generateBoardingPass(BoardingPassDTO boardingPassDTO);
    BoardingPassDTO getBoardingPassById(Long id);
    List<BoardingPassDTO> getAllBoardingPasses();
    BoardingPassDTO updateBoardingPass(Long id, BoardingPassDTO updatedBoardingPassDTO);
    void deleteBoardingPass(Long id);
}
