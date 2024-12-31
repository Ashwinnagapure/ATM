package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CharterDTO;
import com.airTransport.atm_backend.service.CharterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/charter")
public class CharterController {

    @Autowired
    private CharterService charterService;

    @PostMapping("/create")
    public CharterDTO createCharter(@RequestBody CharterDTO charterDTO) {
        return charterService.createCharter(charterDTO);
    }

    @GetMapping("/{charterId}")
    public CharterDTO getCharterById(@PathVariable Long charterId) {
        return charterService.getCharterById(charterId);
    }
}
