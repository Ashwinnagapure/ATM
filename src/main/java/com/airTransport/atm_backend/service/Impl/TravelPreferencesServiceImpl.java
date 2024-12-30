package com.airTransport.atm_backend.service.Impl;
import com.airTransport.atm_backend.model.TravelPreferences;
import com.airTransport.atm_backend.repository.TravelPreferencesRepository;
import com.airTransport.atm_backend.service.TravelPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TravelPreferencesServiceImpl implements TravelPreferencesService {

    @Autowired
    private TravelPreferencesRepository travelPreferencesRepository;

    @Override
    public TravelPreferences createTravelPreferences(TravelPreferences travelPreferences) {
        return travelPreferencesRepository.save(travelPreferences);
    }

    @Override
    public TravelPreferences saveTravelPreferencesByPassengerId(Long passengerId, TravelPreferences travelPreferences) {
        TravelPreferences newTravelPreferences = new TravelPreferences();
        newTravelPreferences.setPassengerId(passengerId);
        newTravelPreferences.setTravelClass(travelPreferences.getTravelClass());
        newTravelPreferences.setMealPreference(travelPreferences.getMealPreference());
        newTravelPreferences.setAirlinePreference(travelPreferences.getAirlinePreference());
        newTravelPreferences.setDepartureTime(travelPreferences.getDepartureTime());
        newTravelPreferences.setArrivalTime(travelPreferences.getArrivalTime());
        return travelPreferencesRepository.save(newTravelPreferences);
    }

    @Override
    public TravelPreferences updateTravelPreferences(Long travelPreferencesId, TravelPreferences travelPreferences) {
        TravelPreferences existingPreferences = travelPreferencesRepository.findById(travelPreferencesId).orElseThrow(
                () -> new RuntimeException("TravelPreferences not found with id: " + travelPreferencesId));
        existingPreferences.setTravelClass(travelPreferences.getTravelClass());
        existingPreferences.setMealPreference(travelPreferences.getMealPreference());
        existingPreferences.setAirlinePreference(travelPreferences.getAirlinePreference());
        existingPreferences.setDepartureTime(travelPreferences.getDepartureTime());
        existingPreferences.setArrivalTime(travelPreferences.getArrivalTime());
        return travelPreferencesRepository.save(existingPreferences);
    }

    @Override
    public List<TravelPreferences> getTravelPreferencesByPassengerId(Long passengerId) {
        List<TravelPreferences> tpr = travelPreferencesRepository.findByPassengerId(passengerId);
        if(tpr.isEmpty()) {
            throw new RuntimeException("TravelPreferences not found with passenger id: " + passengerId);
        }
        else {
            return tpr;
        }
    }

    @Override
    public TravelPreferences getTravelPreferencesById(Long travelPreferencesId) {
        return travelPreferencesRepository.findById(travelPreferencesId)
                .orElseThrow(() -> new RuntimeException("TravelPreferences not found with id: " + travelPreferencesId));
    }


    @Override
    public List<TravelPreferences> getAllTravelPreferences() {
        return travelPreferencesRepository.findAll();
    }

    @Override
    public void deleteTravelPreferences(Long travelPreferencesId) {
        if (travelPreferencesRepository.existsById(travelPreferencesId)) {
            travelPreferencesRepository.deleteById(travelPreferencesId);
        } else {
            throw new RuntimeException("TravelPreferences not found with id: " + travelPreferencesId);
        }
    }
}