package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Log;
import com.airTransport.atm_backend.repository.LogRepository;
import com.airTransport.atm_backend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log saveLog(String message) {
        Log log = new Log(LocalDateTime.now(), message);
        return logRepository.save(log);
    }

    @Override
    public Log retrieveLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with ID: " + id));
    }

    @Override
    public List<Log> retrieveAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public void deleteLog(Long id) {
        if (!logRepository.existsById(id)) {
            throw new RuntimeException("Log not found with ID: " + id);
        }
        logRepository.deleteById(id);
    }
}
