package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.repository.CharterRepository;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharterServiceImpl implements CharterService {

    @Autowired
    private CharterRepository charterRepository;

    @Override
    public Charter saveCharter(Charter charter) {
        return charterRepository.save(charter);
    }

    @Override
    public List<Charter> getAllCharters() {
        return charterRepository.findAll();
    }

    @Override
    public Charter getCharterById(long id) {
        return charterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charter not found with ID: " + id));
    }

    @Override
    public Charter updateCharter(long id, Charter charter) {
        Charter existingCharter = getCharterById(id);
        existingCharter.setVehicleType(charter.getVehicleType());
        existingCharter.setSource(charter.getSource());
        existingCharter.setDestination(charter.getDestination());
        existingCharter.setDeparture(charter.getDeparture());
        existingCharter.setArrival(charter.getArrival());
        existingCharter.setStatus(charter.getStatus());
        return charterRepository.save(existingCharter);
    }

    @Override
    public void deleteCharter(long id) {
        charterRepository.deleteById(id);
    }
}
