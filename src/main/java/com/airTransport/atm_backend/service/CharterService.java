package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Charter;

import java.util.List;

public interface CharterService {
    Charter addCharter(Charter charter);
    Charter getCharterById(Long id);
    List<Charter> getAllCharters();
    Charter updateCharter(Long id, Charter updatedCharter);
    void deleteCharter(Long id);
}
