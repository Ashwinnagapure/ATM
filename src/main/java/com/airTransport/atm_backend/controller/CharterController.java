package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CharterDTO;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charters")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CharterController {

    @Autowired
    private CharterService charterService;

    @PostMapping
    public ResponseEntity<Charter> addCharter(@RequestBody CharterDTO charterDTO) {
        return ResponseEntity.ok(charterService.addCharter(charterDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charter> getCharterById(@PathVariable Long id) {
        return ResponseEntity.ok(charterService.getCharterById(id));
    }

    @GetMapping
    public ResponseEntity<List<Charter>> getAllCharters() {
        return ResponseEntity.ok(charterService.getAllCharters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Charter> updateCharter(@PathVariable Long id, @RequestBody CharterDTO updatedCharterDTO) {
        return ResponseEntity.ok(charterService.updateCharter(id, updatedCharterDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharter(@PathVariable Long id) {
        charterService.deleteCharter(id);
        return ResponseEntity.noContent().build();
    }
}
