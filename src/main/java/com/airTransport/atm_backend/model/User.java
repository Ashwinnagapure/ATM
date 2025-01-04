package com.airTransport.atm_backend.model;

// sadh ghetl ahe pan
// no enum
// as all are of USER role

// enum delete karun taku
import com.airTransport.atm_backend.model.enums.UserType;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(unique = true, nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 65)
    private String password;

    @Column(nullable = false)
    private String role = "USER";  // Default role for all users

    // Getters, Setters, and Constructor
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}