package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Log;
import java.util.List;

public interface LogService {
    Log saveLog(String message);
    Log retrieveLog(Long id);
    List<Log> retrieveAllLogs();
    void deleteLog(Long id);
}
