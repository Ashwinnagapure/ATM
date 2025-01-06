package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boardingPasses")
public class BoardingPassController {

    @Autowired
    private BoardingPassService boardingPassService;

    @GetMapping
    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassService.getAllBoardingPasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardingPass> getBoardingPassById(@PathVariable Long id) {
        return ResponseEntity.ok(boardingPassService.getBoardingPassById(id));
    }

    @PostMapping
    public BoardingPass createBoardingPass(@RequestBody BoardingPass boardingPass) {
        return boardingPassService.createBoardingPass(boardingPass);
    }

    @PostMapping("/generate/{paymentId}")
    public ResponseEntity<BoardingPass> createBoardingPass(@PathVariable Long paymentId, @RequestBody BoardingPass boardingPass) {
        BoardingPass createdBoardingPass = boardingPassService.createBoardingPassForPayment(paymentId, boardingPass);
        return ResponseEntity.ok(createdBoardingPass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardingPass> updateBoardingPass(@PathVariable Long id, @RequestBody BoardingPass boardingPass) {
        return ResponseEntity.ok(boardingPassService.updateBoardingPass(id, boardingPass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardingPass(@PathVariable Long id) {
        boardingPassService.deleteBoardingPass(id);
        return ResponseEntity.noContent().build();
    }
}
