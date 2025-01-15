package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightSearchService, FlightManagementService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AdminService adminService;

    @Override
    public boolean trackFlightStatus(long flightId) {
        return flightRepository.existsById(flightId);
    }

    @Override
    public boolean scheduleFlights(FlightCreateDTO flightCreateDTO) {

        if (flightCreateDTO.getFlightName() == null || flightCreateDTO.getDeparture() == null) {
            return false; // Invalid data
        }

        Flight flight = convertToFlightEntity(flightCreateDTO);
        flightRepository.save(flight);
        return true;
    }

    @Override
    public List<FlightResponseDTO> getFlightsByAirline(String airlineName) {
        // Fetch flights by airline name
        List<Flight> flights = flightRepository.findByAirline(airlineName);
        return flights.stream()
                .map(this::convertToFlightResponseDTO)
                .collect(Collectors.toList());
    }
    @Override
    public boolean cancelFlights(long flightId) {
        if (flightRepository.existsById(flightId)) {
            flightRepository.deleteById(flightId);
            return true;
        }
        return false;
    }

    @Override
    public List<FlightResponseDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll(); // Fetch all flights from the database
        return flights.stream()
                .map(this::convertToFlightResponseDTO) // Convert each flight entity to DTO
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponseDTO getFlightById(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new NotFoundException("Flight not found with ID: " + flightId));
        return convertToFlightResponseDTO(flight);
    }

    @Override
    public List<FlightResponseDTO> sortByPrice() {
        return flightRepository.findAllByOrderByPriceAsc().stream()
                .map(this::convertToFlightResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponseDTO> sortByAirline() {
        return flightRepository.findAllByOrderByAirlineAsc().stream()
                .map(this::convertToFlightResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponseDTO> sortByClass() {
        return flightRepository.findAllByOrderByFlightClassAsc().stream()
                .map(this::convertToFlightResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponseDTO> searchFlights(String source, String destination) {
        // Fetch flights based on the provided source and destination
        List<Flight> flights = flightRepository.findBySourceAndDestination(source, destination);
        return flights.stream()
                .map(this::convertToFlightResponseDTO)
                .collect(Collectors.toList());
    }

    private Flight convertToFlightEntity(FlightCreateDTO dto) {
        Flight flight = new Flight();
        flight.setFlightName(dto.getFlightName());
        flight.setDeparture(dto.getDeparture());
        flight.setArrival(dto.getArrival());
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        flight.setPrice(dto.getPrice());
        flight.setAirline(dto.getAirline());
        flight.setFlightClass(dto.getFlightClass());
        flight.setAdmin(adminService.getAdminById(dto.getAdminId()));
        return flight;
    }

    private FlightResponseDTO convertToFlightResponseDTO(Flight flight) {
        FlightResponseDTO dto = new FlightResponseDTO();
        dto.setFlightId(flight.getFlightId());
        dto.setFlightName(flight.getFlightName());
        dto.setDeparture(flight.getDeparture());
        dto.setArrival(flight.getArrival());
        dto.setSource(flight.getSource());
        dto.setDestination(flight.getDestination());
        dto.setPrice(flight.getPrice());
        dto.setAirline(flight.getAirline());
        dto.setFlightClass(flight.getFlightClass());
        return dto;
    }




}
