package com.airTransport.atm_backend.model;
import com.airTransport.atm_backend.service.TravelPreferences;
import java.util.ArrayList;
import java.util.List;


public class Passenger extends User implements TravelPreferences {
    private long passengerId;
    private String contact;
    private Notification notification;

    public boolean saveTravelPreferences(String params) {
        // Implementation
        return true;
    }


    public String requestRefund(String params){
        return "";
    }

    public Boolean selectPaymentMethod(String  params){
        return true;
    }

// In place of integers we have to Documents as List

//public Boolean storeTravelDocuments(String abc, List<Integer> params) {
//        return true;
//}
//
// public List<Integer> getTravelDocuments(String params) {
//        return new ArrayList<>();
// }

    @Override
    public void saveTravelPreferences(String params, TravelPreferences a) {

    }

    @Override
    public TravelPreferences getTravelPreferences(String params) {
        return null;
    }



}