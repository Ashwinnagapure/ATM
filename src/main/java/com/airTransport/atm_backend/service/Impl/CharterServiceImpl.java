package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CharterDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.AdminRepository;
import com.airTransport.atm_backend.repository.CharterRepository;
import com.airTransport.atm_backend.repository.UserRepository;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharterServiceImpl implements CharterService {

    @Autowired
    private CharterRepository charterRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Charter addCharter(CharterDTO charterDTO) {
        Admin admin = adminRepository.findById(charterDTO.getAdminId())
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + charterDTO.getAdminId()));

        Charter charter = new Charter();
        charter.setVehicleType(charterDTO.getVehicleType());
        charter.setPrice(charterDTO.getPrice());
        charter.setDepartureTime(charterDTO.getDepartureTime());
        charter.setArrivalTime(charterDTO.getArrivalTime());
        charter.setAdmin(admin);

        return charterRepository.save(charter);
    }

    @Override
    public Charter getCharterById(Long id) {
        Charter charter = charterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Charter not found with ID: " + id));

        CharterDTO charterDTO = new CharterDTO();
        charterDTO.setId(charter.getId());
        charterDTO.setVehicleType(charter.getVehicleType());
        charterDTO.setPrice(charter.getPrice());
        charterDTO.setDepartureTime(charter.getDepartureTime());
        charterDTO.setArrivalTime(charter.getArrivalTime());
        charterDTO.setAdminId(charter.getAdmin().getId());
        charterDTO.setUserIds(
                charter.getUsers().stream().map(User::getId).collect(Collectors.toList())
        );
        return charter;
    }


    @Override
    public List<Charter> getAllCharters() {
        return charterRepository.findAll();
    }

    @Override
    public Charter updateCharter(Long id, CharterDTO updatedCharterDTO) {
        Charter existingCharter = getCharterById(id);
        Admin admin = adminRepository.findById(updatedCharterDTO.getAdminId())
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + updatedCharterDTO.getAdminId()));

        existingCharter.setVehicleType(updatedCharterDTO.getVehicleType());
        existingCharter.setPrice(updatedCharterDTO.getPrice());
        existingCharter.setDepartureTime(updatedCharterDTO.getDepartureTime());
        existingCharter.setArrivalTime(updatedCharterDTO.getArrivalTime());
        existingCharter.setAdmin(admin);

        return charterRepository.save(existingCharter);
    }

    @Override
    public void deleteCharter(Long id) {
        Charter charter = getCharterById(id);
        charterRepository.delete(charter);
    }
}
