package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.TravelPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelPreferencesRepository extends JpaRepository<TravelPreferences, Long> {
    List<TravelPreferences> findByPassengerId(Long passengerId);
}