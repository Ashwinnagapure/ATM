package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.FlightResponseDTO;
import java.util.List;

public interface FlightSearchService {

    List<FlightResponseDTO> sortByPrice();  // Return DTO
    List<FlightResponseDTO> sortByAirline(); // Return DTO
    List<FlightResponseDTO> sortByClass(); // Return DTO

    List<FlightResponseDTO> searchFlights(String source, String destination);

    List<FlightResponseDTO> getFlightsByAirline(String airlineName);


}
