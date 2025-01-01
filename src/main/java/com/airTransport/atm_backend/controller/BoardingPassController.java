package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boardingPasses")
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
