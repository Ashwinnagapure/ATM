package com.airTransport.atm_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "passengers")
@PrimaryKeyJoinColumn(name = "id")
public class Passenger extends User {


    private String complaint;


    public String getComplaint() {
        return complaint;
    }
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }



}
