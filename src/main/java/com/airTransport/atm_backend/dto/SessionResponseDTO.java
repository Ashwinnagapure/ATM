package com.airTransport.atm_backend.dto;

public class SessionResponseDTO {
    private String sessionUrl;

    // Constructor
    public SessionResponseDTO(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }

    // Getters and Setters
    public String getSessionUrl() {
        return sessionUrl;
    }

    public void setSessionUrl(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }
}
