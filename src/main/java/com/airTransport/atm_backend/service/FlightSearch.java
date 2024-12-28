package com.airTransport.atm_backend.service;

import java.util.List;

public interface FlightSearch {
    public List<String> sortByPrice(String params) ;
    public List<String> sortByAirline(String params) ;
    public List<String> sortByClass(String params) ;
}
