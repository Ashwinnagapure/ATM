package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.service.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boarding-passes")
public class BoardingPassController {

    @Autowired
    private BoardingPassService boardingPassService;

    @PostMapping
    public ResponseEntity<BoardingPass> generateBoardingPass(@RequestBody BoardingPass boardingPass) {
        return ResponseEntity.ok(boardingPassService.generateBoardingPass(boardingPass));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardingPass> getBoardingPassById(@PathVariable Long id) {
        return ResponseEntity.ok(boardingPassService.getBoardingPassById(id));
    }

    @GetMapping
    public ResponseEntity<List<BoardingPass>> getAllBoardingPasses() {
        return ResponseEntity.ok(boardingPassService.getAllBoardingPasses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardingPass> updateBoardingPass(@PathVariable Long id, @RequestBody BoardingPass updatedBoardingPass) {
        return ResponseEntity.ok(boardingPassService.updateBoardingPass(id, updatedBoardingPass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardingPass(@PathVariable Long id) {
        boardingPassService.deleteBoardingPass(id);
        return ResponseEntity.noContent().build();
    }
}
