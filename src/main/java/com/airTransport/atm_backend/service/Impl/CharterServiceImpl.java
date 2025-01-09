package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
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
    public Charter addCharter(Charter charter) {
        return charterRepository.save(charter);
    }

    @Override
    public Charter getCharterById(Long id) {
        return charterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Charter not found with ID: " + id));
    }

    @Override
    public List<Charter> getAllCharters() {
        return charterRepository.findAll();
    }

    @Override
    public Charter updateCharter(Long id, Charter updatedCharter) {
        Charter existingCharter = getCharterById(id);
        existingCharter.setVehicleType(updatedCharter.getVehicleType());
        existingCharter.setPrice(updatedCharter.getPrice());
        existingCharter.setDepartureTime(updatedCharter.getDepartureTime());
        existingCharter.setArrivalTime(updatedCharter.getArrivalTime());
        return charterRepository.save(existingCharter);
    }

    @Override
    public void deleteCharter(Long id) {
        Charter charter = getCharterById(id);
        charterRepository.delete(charter);
    }
}
