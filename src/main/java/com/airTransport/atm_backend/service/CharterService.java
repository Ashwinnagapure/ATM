package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CharterDTO;

public interface CharterService {
    CharterDTO createCharter(CharterDTO charterDTO);
    CharterDTO getCharterById(Long charterId);
}
