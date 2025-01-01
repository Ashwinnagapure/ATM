package com.airTransport.atm_backend.model;

import jakarta.persistence.*;

@Entity
public class Charter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charterId;

    @Column(nullable = false)
    private String vehicleType; // Helicopter or Private Jet

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String flightNumber;

    // Getters and Setters
    public Long getCharterId() {
        return charterId;
    }

    public void setCharterId(Long charterId) {
        this.charterId = charterId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    // Business Method Example
    public boolean isLuxury() {
        return "privateJet".equalsIgnoreCase(vehicleType);
    }
}
