package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PassengerDTO;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/{bookingId}")
    public ResponseEntity<PassengerDTO> addPassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable Long bookingId) {
        Passenger passenger = passengerService.addPassenger(mapToEntity(passengerDTO), bookingId);
        return ResponseEntity.ok(mapToDTO(passenger));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PassengerDTO>> getPassengersByBookingId(@PathVariable Long bookingId) {
        List<Passenger> passengers = passengerService.getPassengersByBookingId(bookingId);
        List<PassengerDTO> passengerDTOs = passengers.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(passengerDTOs);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long passengerId) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.ok(mapToDTO(passenger));
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Long passengerId, @RequestBody PassengerDTO passengerDTO) {
        Passenger updatedPassenger = passengerService.updatePassenger(passengerId, mapToEntity(passengerDTO));
        return ResponseEntity.ok(mapToDTO(updatedPassenger));
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok("Passenger deleted successfully");
    }

    private Passenger mapToEntity(PassengerDTO dto) {
        Passenger passenger = new Passenger();
        passenger.setName(dto.getName());
        passenger.setEmail(dto.getEmail());
        passenger.setPhone(dto.getPhone());
        return passenger;
    }

    private PassengerDTO mapToDTO(Passenger passenger) {
        PassengerDTO dto = new PassengerDTO();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setEmail(passenger.getEmail());
        dto.setPhone(passenger.getPhone());
        dto.setBookingId(passenger.getBooking().getId());
        return dto;
    }
}
