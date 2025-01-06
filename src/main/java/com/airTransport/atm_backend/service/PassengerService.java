package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PassengerService {
    public  String addPassenger(Passenger passenger);
    Passenger getPassengerById(Long PassengerId);
    List<Passenger> getAllPassengers();
    String deletePassenger(Long PassengerId);
    Passenger updatePassenger(Passenger passenger);
}
