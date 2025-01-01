package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charters")
public class CharterController {

    @Autowired
    private CharterService charterService;

    @PostMapping
    public ResponseEntity<Charter> createCharter(@RequestBody Charter charter) {
        Charter createdCharter = charterService.saveCharter(charter);
        return ResponseEntity.ok(createdCharter);
    }

    @GetMapping
    public ResponseEntity<List<Charter>> getAllCharters() {
        List<Charter> charters = charterService.getAllCharters();
        return ResponseEntity.ok(charters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charter> getCharterById(@PathVariable long id) {
        Charter charter = charterService.getCharterById(id);
        return ResponseEntity.ok(charter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Charter> updateCharter(@PathVariable long id, @RequestBody Charter updatedCharter) {
        Charter charter = charterService.updateCharter(id, updatedCharter);
        return ResponseEntity.ok(charter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharter(@PathVariable long id) {
        charterService.deleteCharter(id);
        return ResponseEntity.noContent().build();
    }
}
