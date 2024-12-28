package com.airTransport.atm_backend.model;
public class Baggage {
    private long baggageld;
    private Booking booking;
    private boolean baggageLimit;
    private Double weight;
    private int luggageCount;


    public boolean getBaggageLimit( String params){
        return true ;
    }

    public boolean reportLostBaggage(String params) {
        return  true;
    }
}
