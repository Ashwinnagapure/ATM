package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CharterDTO;
import com.airTransport.atm_backend.model.Charter;

import java.util.List;

public interface CharterService {
    Charter addCharter(CharterDTO charterDTO);
    Charter getCharterById(Long id);
    List<Charter> getAllCharters();
    Charter updateCharter(Long id, CharterDTO updatedCharterDTO);
    void deleteCharter(Long id);
}
