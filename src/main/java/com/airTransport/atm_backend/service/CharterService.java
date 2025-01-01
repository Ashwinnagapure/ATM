package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Charter;

import java.util.List;

public interface CharterService {

    Charter saveCharter(Charter charter);

    List<Charter> getAllCharters();

    Charter getCharterById(long id);

    Charter updateCharter(long id, Charter charter);

    void deleteCharter(long id);
}
