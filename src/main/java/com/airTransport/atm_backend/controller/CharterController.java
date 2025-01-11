package com.airTransport.atm_backend.controller;

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
    public ResponseEntity<Charter> addCharter(@RequestBody Charter charter) {
        return ResponseEntity.ok(charterService.addCharter(charter));
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
    public ResponseEntity<Charter> updateCharter(@PathVariable Long id, @RequestBody Charter updatedCharter) {
        return ResponseEntity.ok(charterService.updateCharter(id, updatedCharter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharter(@PathVariable Long id) {
        charterService.deleteCharter(id);
        return ResponseEntity.noContent().build();
    }
}
