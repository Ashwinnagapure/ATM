package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.repository.BoardingPassRepository;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {

    @Autowired
    private BoardingPassRepository boardingPassRepository;

    @Override
    public BoardingPass generateBoardingPass(BoardingPass boardingPass) {
        return boardingPassRepository.save(boardingPass);
    }

    @Override
    public BoardingPass getBoardingPassById(Long id) {
        return boardingPassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Boarding Pass not found with ID: " + id));
    }

    @Override
    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassRepository.findAll();
    }

    @Override
    public BoardingPass updateBoardingPass(Long id, BoardingPass updatedBoardingPass) {
        BoardingPass existingBoardingPass = getBoardingPassById(id);
        existingBoardingPass.setGate(updatedBoardingPass.getGate());
        existingBoardingPass.setSeatNumber(updatedBoardingPass.getSeatNumber());
        return boardingPassRepository.save(existingBoardingPass);
    }

    @Override
    public void deleteBoardingPass(Long id) {
        BoardingPass boardingPass = getBoardingPassById(id);
        boardingPassRepository.delete(boardingPass);
    }
}
