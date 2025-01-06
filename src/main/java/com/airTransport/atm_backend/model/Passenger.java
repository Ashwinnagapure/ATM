package com.airTransport.atm_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "passengers")
@PrimaryKeyJoinColumn(name = "id")
public class Passenger extends User {


    private String complaint;

    @ManyToMany
    @JoinTable(
            name = "passenger_flights",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")

    )
    private List<Flight> flights;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private List<Notification> notification;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @JsonBackReference
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    private List<Charter>charters;

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public List<Notification> getNotification() {
        return notification;
    }
    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }

    public List<Booking> getBookings(){
        return bookings;
    }
    public void setBookings(List<Booking>bookings){
        this.bookings = bookings;
    }

    public List<Charter>getCharters(){
        return charters;
    }
    public void setCharters(List<Charter>charters){
        this.charters = charters;
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void setFlights(List<Flight>flights){
        this.flights=flights;
    }

}
