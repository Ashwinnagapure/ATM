package com.airTransport.atm_backend.dto;

import java.util.List;

public class AdminDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
    private List<FlightDTO> flights;
    private List<CrewManagementDTO> crewManagements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }

    public List<CrewManagementDTO> getCrewManagements() {
        return crewManagements;
    }

    public void setCrewManagements(List<CrewManagementDTO> crewManagements) {
        this.crewManagements = crewManagements;
    }
}
