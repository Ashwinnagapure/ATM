package com.airTransport.atm_backend.model;

import java.util.ArrayList;
import java.util.List;

public class Charter extends Booking{
    private long charterId;
    private enum vehicleType{helicopter, privateJet};
    private Payment payment;


    public List<String> sortByPrice(){
        return new ArrayList<>();
    }
}
