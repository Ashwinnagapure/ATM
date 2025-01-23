package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.PassengerDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "${CORS}", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // for registration users
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        String response = userService.registerUser(userDTO);
        return ResponseEntity.ok(response);
    }

    // for login of users
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        UserDTO response = userService.loginUser(loginDTO);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        userService.logout();
        return ResponseEntity.ok("Logout successful!");
    }
}
