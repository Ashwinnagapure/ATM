package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.model.enums.VehicleType;
import com.airTransport.atm_backend.model.enums.CharterStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;


    @OneToOne(mappedBy = "charter", cascade = CascadeType.ALL)
    private Booking booking;

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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
