package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.BoardingPassRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {

    @Autowired
    private BoardingPassRepository boardingPassRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassRepository.findAll();
    }

    @Override
    public BoardingPass createBoardingPassForPayment(Long paymentId, BoardingPass boardingPass) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
        boardingPass.setPayment(payment);
        return boardingPassRepository.save(boardingPass);
    }

    @Override
    public BoardingPass getBoardingPassById(Long id) {
        return boardingPassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BoardingPass not found with id: " + id));
    }

    @Override
    public BoardingPass createBoardingPass(BoardingPass boardingPass) {
        return boardingPassRepository.save(boardingPass);
    }

    @Override
    public BoardingPass updateBoardingPass(Long id, BoardingPass boardingPass) {
        BoardingPass existingBoardingPass = getBoardingPassById(id);
        existingBoardingPass.setBoardingTime(boardingPass.getBoardingTime());
        existingBoardingPass.setBoardingDate(boardingPass.getBoardingDate());
        existingBoardingPass.setBoardingGate(boardingPass.getBoardingGate());
        existingBoardingPass.setSeat(boardingPass.getSeat());
        return boardingPassRepository.save(existingBoardingPass);
    }

    @Override
    public void deleteBoardingPass(Long id) {
        boardingPassRepository.deleteById(id);
    }
}
