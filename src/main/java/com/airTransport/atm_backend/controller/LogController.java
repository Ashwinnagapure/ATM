package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Log;
import com.airTransport.atm_backend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public Log saveLog(@RequestBody String message) {
        return logService.saveLog(message);
    }

    @GetMapping("/{id}")
    public Log retrieveLog(@PathVariable Long id) {
        return logService.retrieveLog(id);
    }

    @GetMapping
    public List<Log> retrieveAllLogs() {
        return logService.retrieveAllLogs();
    }

    @DeleteMapping("/{id}")
    public String deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
        return "Log with ID " + id + " has been deleted.";
    }
}
