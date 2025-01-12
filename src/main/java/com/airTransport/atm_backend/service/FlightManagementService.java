package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import java.util.List;

public interface FlightManagementService {

    boolean trackFlightStatus(long flightId);
    boolean scheduleFlights(FlightCreateDTO flightCreateDTO); // Accept DTO
    boolean cancelFlights(long flightId);


    List<FlightResponseDTO> getAllFlights();
    FlightResponseDTO getFlightById(Long flightId); // Return DTO
}
