package com.airTransport.atm_backend.service;
import com.airTransport.atm_backend.model.TravelPreferences;

import java.util.List;

public interface TravelPreferencesService {

    TravelPreferences createTravelPreferences(TravelPreferences travelPreferences);
    TravelPreferences saveTravelPreferencesByPassengerId(Long passengerId, TravelPreferences travelPreferences);
    TravelPreferences updateTravelPreferences(Long travelPreferencesId, TravelPreferences travelPreferences);
    List<TravelPreferences> getTravelPreferencesByPassengerId(Long passengerId);
    TravelPreferences getTravelPreferencesById(Long travelPreferencesId);
    List<TravelPreferences> getAllTravelPreferences();
    void deleteTravelPreferences(Long travelPreferencesId);
}