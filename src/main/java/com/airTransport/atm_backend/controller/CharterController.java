package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.CharterService;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charters")
public class CharterController {

    @Autowired
    private CharterService charterService;

    @Autowired
    private PassengerService passengerService;


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

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Charter>> getChartersByPassenger(@PathVariable Long passengerId) {
        return ResponseEntity.ok(charterService.getChartersByPassenger(passengerId));
    }


    @PostMapping("/assign-passenger/{charterId}/{passengerId}")
    public String assignPassengerToCharter(@PathVariable Long charterId, @PathVariable Long passengerId) {
        Charter charter = charterService.getCharterById(charterId);
        Passenger passenger = passengerService.getPassengerById(passengerId);

        if (charter != null && passenger != null) {
            charter.setPassenger(passenger);
            charterService.saveCharter(charter);
            return "Passenger assigned to charter successfully";
        }
        return "Charter or Passenger not found";
    }
}
