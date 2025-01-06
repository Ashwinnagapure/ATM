package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @OneToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "charter_id")
    private Charter charter;

    private LocalDateTime bookingDate;
    private LocalDateTime travelDate;
    private String status;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Baggage> baggages;

    public Booking() {}
    public Booking(Passenger passenger, Flight flight, LocalDateTime bookingDate, LocalDateTime travelDate, String status) {
        this.passenger = passenger;
        this.flight = flight;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.status = status;
    }



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDateTime travelDate) {
        this.travelDate = travelDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(List<Baggage> baggages) {
        this.baggages = baggages;
    }
    public Charter getCharter() {
        return charter;
    }
    public void setCharter(Charter charter) {
        this.charter = charter;
    }
    public void addBaggage(Baggage baggage) {
        baggages.add(baggage);
        baggage.setBooking(this);
    }
}
