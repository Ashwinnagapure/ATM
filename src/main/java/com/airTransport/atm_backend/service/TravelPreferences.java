package com.airTransport.atm_backend.service;

public interface TravelPreferences {
    public void saveTravelPreferences(String params, TravelPreferences tp);
    public TravelPreferences getTravelPreferences(String params);
}
