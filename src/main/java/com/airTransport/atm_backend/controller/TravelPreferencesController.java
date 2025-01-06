package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.TravelPreferences;
import com.airTransport.atm_backend.service.TravelPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel-preferences")
public class TravelPreferencesController {

    @Autowired
    private TravelPreferencesService travelPreferencesService;

    @PostMapping //save or add travel preferences
    public ResponseEntity<TravelPreferences> createTravelPreferences(@RequestBody TravelPreferences travelPreferences) {
        return ResponseEntity.ok(travelPreferencesService.createTravelPreferences(travelPreferences));
    }

    @PostMapping("/passenger/{passengerId}") //saving travel preferences using a particular passenger id
    public ResponseEntity<TravelPreferences> saveTravelPreferencesByPassengerId(@PathVariable Long passengerId, @RequestBody TravelPreferences travelPreferences) {
        return ResponseEntity.ok(travelPreferencesService.saveTravelPreferencesByPassengerId(passengerId, travelPreferences));
    }

    @PutMapping("/{travelPreferencesId}") //updating travel preferences using travel preferences id
    public ResponseEntity<TravelPreferences> updateTravelPreferences(@PathVariable Long travelPreferencesId, @RequestBody TravelPreferences travelPreferences) {
        return ResponseEntity.ok(travelPreferencesService.updateTravelPreferences(travelPreferencesId, travelPreferences));
    }

    @GetMapping("/passenger/{passengerId}") //getting travel preferences using a particular passenger id
    public ResponseEntity<List<TravelPreferences>> getTravelPreferencesByPassengerId(@PathVariable Long passengerId) {
        return ResponseEntity.ok(travelPreferencesService.getTravelPreferencesByPassengerId(passengerId));
    }

    @GetMapping("/{travelPreferencesId}") //getting travel preferences using travel preferences id
    public ResponseEntity<TravelPreferences> getTravelPreferencesById(@PathVariable Long travelPreferencesId) {
        return ResponseEntity.ok(travelPreferencesService.getTravelPreferencesById(travelPreferencesId));
    }

    @GetMapping //getting all travel preferences
    public ResponseEntity<List<TravelPreferences>> getAllTravelPreferences() {
        return ResponseEntity.ok(travelPreferencesService.getAllTravelPreferences());
    }

    @DeleteMapping("/{travelPreferencesId}") //deleting travel preferences using travel preferences id
    public ResponseEntity<Void> deleteTravelPreferences(@PathVariable Long travelPreferencesId) {
        travelPreferencesService.deleteTravelPreferences(travelPreferencesId);
        return ResponseEntity.noContent().build();
    }
}