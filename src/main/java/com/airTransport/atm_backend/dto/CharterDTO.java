package com.airTransport.atm_backend.dto;

public class CharterDTO {

    private Long charterId;
    private String vehicleType;
    private Double price;
    private String passengerName;
    private String flightNumber;

    // Constructor
    public CharterDTO(Long charterId, String vehicleType, Double price, String passengerName, String flightNumber) {
        this.charterId = charterId;
        this.vehicleType = vehicleType;
        this.price = price;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
    }

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
}
