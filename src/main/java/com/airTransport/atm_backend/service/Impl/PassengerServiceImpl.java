package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
    @Override
    public String addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
        return "Passenger added successfully";
    }

    @Override
    public Passenger getPassengerById(Long PassengerId) {
        return passengerRepository.findById(PassengerId).orElse(null);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public String deletePassenger(Long PassengerId) {
        passengerRepository.deleteById(PassengerId);
        return"Passenger deleted successfully";
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
