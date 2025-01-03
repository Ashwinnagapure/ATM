package com.airTransport.atm_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Flight> flights;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Notification> notifications;


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<CrewManagement> crewManagements;

    public List<Flight> getFlights() {
        return flights;
    }
    public void setFlights(List<Flight>flights){
        this.flights=flights;
    }
    public List<Notification> getNotifications() {
        return notifications;
    }
    public void setNotifications(List<Notification>notifications){
        this.notifications=notifications;
    }
    public List<CrewManagement> getCrewManagements() {
        return crewManagements;
    }
    public void setCrewManagements(List<CrewManagement>crewManagements){
        this.crewManagements=crewManagements;
    }
}
