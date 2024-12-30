package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public String addPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return "Passenger added successfully";
    }

    @GetMapping("/{passengerId}")
    public Passenger getPassengerById(@PathVariable("passengerId") Long passengerId){
        return passengerService.getPassengerById(passengerId);
    }

    @GetMapping
    public List<Passenger> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @PutMapping
    public String updatePassenger(@RequestBody Passenger passenger){
        passengerService.updatePassenger(passenger);
        return "Passenger updated successfully";
    }

    @DeleteMapping("/{passengerId}")
    public String deletePassenger(@PathVariable Long passengerId){
        passengerService.deletePassenger(passengerId);
        return "Passenger deleted successfully";
    }
}
