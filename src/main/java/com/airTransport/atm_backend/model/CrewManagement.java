package com.airTransport.atm_backend.model;

import com.airTransport.atm_backend.model.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "crew_management")
public class CrewManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING) // Maps Enum values as Strings in the database
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean availability;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adminId", nullable = false)
    private Admin admin;

    // Constructors, Getters, and Setters
    public CrewManagement() {
    }

    public CrewManagement(String name, Role role, boolean availability) {
        this.name = name;
        this.role = role;
        this.availability = availability;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
