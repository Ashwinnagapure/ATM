package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "charters")
public class Charter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long charterId;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String source;
    private String destination;
    private LocalDateTime departure;
    private LocalDateTime arrival;

    @Enumerated(EnumType.STRING)
    private CharterStatus status;

    public enum VehicleType {
        HELICOPTER, PRIVATE_JET
    }

    public enum CharterStatus {
        ON_TIME, DELAYED, CANCELLED
    }

    // Getters and Setters
    public long getCharterId() {
        return charterId;
    }

    public void setCharterId(long charterId) {
        this.charterId = charterId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public CharterStatus getStatus() {
        return status;
    }

    public void setStatus(CharterStatus status) {
        this.status = status;
    }
}
