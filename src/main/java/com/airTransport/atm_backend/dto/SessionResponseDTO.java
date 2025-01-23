package com.airTransport.atm_backend.dto;

public class SessionResponseDTO {
    private String sessionUrl;

    public SessionResponseDTO(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }

    public String getSessionUrl() {
        return sessionUrl;
    }

    public void setSessionUrl(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }
}
