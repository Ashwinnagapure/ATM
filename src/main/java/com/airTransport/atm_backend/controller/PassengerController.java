package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PassengerDTO;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.Seat;
import com.airTransport.atm_backend.service.PassengerService;
import com.airTransport.atm_backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Value("${CORS}")
    private String corsUrl;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private SeatService seatService; // Added SeatService to fetch Seat by seatId

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/add/{bookingId}/{userId}")
    public ResponseEntity<List<PassengerDTO>> addPassengersToBooking(
            @RequestBody List<PassengerDTO> passengerDTOs,
            @PathVariable Long bookingId, @PathVariable Long userId) {

        // Add passengers with both bookingId and userId
        List<Passenger> passengers = passengerService.addPassengersToBooking(
                passengerDTOs.stream()
                        .map(this::mapToEntity) // Map DTO to entity
                        .collect(Collectors.toList()),
                bookingId,
                userId,
                passengerDTOs.stream().map(PassengerDTO::getSeatId).collect(Collectors.toList()) // Pass seat IDs
        );

        // Map the passengers to DTOs
        List<PassengerDTO> result = passengers.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PassengerDTO>> getPassengersByUserId(@PathVariable Long userId) {
        // Fetch passengers by userId
        List<Passenger> passengers = passengerService.getPassengersByUserId(userId);
        // Convert the Passenger list to DTO and return
        List<PassengerDTO> result = passengers.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PassengerDTO>> getPassengersByBookingId(@PathVariable Long bookingId) {
        List<Passenger> passengers = passengerService.getPassengersByBookingId(bookingId);
        return ResponseEntity.ok(passengers.stream().map(this::mapToDTO).collect(Collectors.toList()));
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long passengerId) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.ok(mapToDTO(passenger));
    }

    // Map PassengerDTO to Passenger entity
    private Passenger mapToEntity(PassengerDTO dto) {
        Passenger passenger = new Passenger();
        passenger.setName(dto.getName());
        passenger.setEmail(dto.getEmail());
        passenger.setPhone(dto.getPhone());

        if (dto.getSeatId() != null) {
            // Fetch the Seat entity by seatId
            Seat seat = seatService.getSeatById(dto.getSeatId())
                    .orElseThrow(() -> new RuntimeException("Seat not found with ID: " + dto.getSeatId()));
            passenger.setSeat(seat); // Associate seat with passenger
        }

        return passenger;
    }

    // Map Passenger entity to PassengerDTO
    private PassengerDTO mapToDTO(Passenger passenger) {
        PassengerDTO dto = new PassengerDTO();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setEmail(passenger.getEmail());
        dto.setPhone(passenger.getPhone());
        dto.setBookingId(passenger.getBooking().getId());
        dto.setUserId(passenger.getUser() != null ? passenger.getUser().getId() : null); // Ensure userId is set
        if (passenger.getSeat() != null) {
            dto.setSeatId(passenger.getSeat().getSeatId()); // Set seatId in DTO
        }
        return dto;
    }
}
