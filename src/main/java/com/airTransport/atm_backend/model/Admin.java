package com.airTransport.atm_backend.model;

import jakarta.persistence.*;
import java.util.List;


// for internal operations
// user admin for login to admin dahsboard
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(unique = true, nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 65)
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Flight> flights;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<CrewManagement> crewManagements;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


    public List<CrewManagement> getCrewManagements() {
        return crewManagements;
    }

    public void setCrewManagements(List<CrewManagement> crewManagements) {
        this.crewManagements = crewManagements;
    }
}