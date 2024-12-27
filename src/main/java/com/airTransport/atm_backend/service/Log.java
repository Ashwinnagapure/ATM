package com.airTransport.atm_backend.service;

public interface Log {
    public Boolean saveLog(String params);
    public String retrieveLog(String params);
}