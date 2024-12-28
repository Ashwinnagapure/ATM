package com.airTransport.atm_backend.repository;

public interface Log {
    public Boolean saveLog(String params);
    public String retrieveLog(String params);
}