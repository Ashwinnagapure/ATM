//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.BoardingPassDTO;
//import com.airTransport.atm_backend.service.BoardingPassService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/boarding-passes")
//@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
//public class BoardingPassController {
//
//    @Autowired
//    private BoardingPassService boardingPassService;
//
//    @PostMapping
//    public ResponseEntity<BoardingPassDTO> generateBoardingPass(@RequestBody BoardingPassDTO boardingPassDTO) {
//        return ResponseEntity.ok(boardingPassService.generateBoardingPass(boardingPassDTO));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BoardingPassDTO> getBoardingPassById(@PathVariable Long id) {
//        return ResponseEntity.ok(boardingPassService.getBoardingPassById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BoardingPassDTO>> getAllBoardingPasses() {
//        return ResponseEntity.ok(boardingPassService.getAllBoardingPasses());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<BoardingPassDTO> updateBoardingPass(@PathVariable Long id, @RequestBody BoardingPassDTO updatedBoardingPassDTO) {
//        return ResponseEntity.ok(boardingPassService.updateBoardingPass(id, updatedBoardingPassDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBoardingPass(@PathVariable Long id) {
//        boardingPassService.deleteBoardingPass(id);
//        return ResponseEntity.noContent().build();
//    }
//}
