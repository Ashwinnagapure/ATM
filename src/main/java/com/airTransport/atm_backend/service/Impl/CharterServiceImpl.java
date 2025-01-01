package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CharterDTO;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.repository.CharterRepository;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharterServiceImpl implements CharterService {

    @Autowired
    private CharterRepository charterRepository;

    @Override
    public CharterDTO createCharter(CharterDTO charterDTO) {
        Charter charter = new Charter();
        charter.setVehicleType(charterDTO.getVehicleType());
        charter.setPrice(charterDTO.getPrice());
        charter.setPassengerName(charterDTO.getPassengerName());
        charter.setFlightNumber(charterDTO.getFlightNumber());

        Charter savedCharter = charterRepository.save(charter);
        return convertToDTO(savedCharter);
    }

    @Override
    public CharterDTO getCharterById(Long charterId) {
        return charterRepository.findById(charterId)
                .map(this::convertToDTO)
                .orElse(null);
    }

    private CharterDTO convertToDTO(Charter charter) {
        return new CharterDTO(
                charter.getCharterId(),
                charter.getVehicleType(),
                charter.getPrice(),
                charter.getPassengerName(),
                charter.getFlightNumber()
        );
    }
}
