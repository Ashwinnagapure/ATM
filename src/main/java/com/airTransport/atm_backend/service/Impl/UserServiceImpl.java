package com.airTransport.atm_backend.service.Impl;


import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.model.enums.UserType;
import com.airTransport.atm_backend.repository.AdminRepository;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.repository.UserRepository;
import com.airTransport.atm_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return "Email is already taken!";
        }

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return "Username is already taken!";
        }

        // Create a new User entity
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        newUser.setUserType(userDTO.getUserType()); // Set UserType
        User savedUser = userRepository.save(newUser);


        if (userDTO.getUserType() == UserType.PASSENGER) {
            Passenger passenger = new Passenger();
            passenger.setUserId(savedUser.getUserId());
            passenger.setUsername(savedUser.getUsername());
            passenger.setEmail(savedUser.getEmail());
            passenger.setPassword(savedUser.getPassword());
            passenger.setUserType(savedUser.getUserType());
            passengerRepository.save(passenger);
        } else if (userDTO.getUserType() == UserType.ADMIN) {
            Admin admin = new Admin();
            admin.setUserId(savedUser.getUserId());
            admin.setUsername(savedUser.getUsername());
            admin.setEmail(savedUser.getEmail());
            admin.setPassword(savedUser.getPassword());
            admin.setUserType(savedUser.getUserType());
            adminRepository.save(admin);
        }

        return "User registered successfully!";
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }

    @Override
    public void logout() {
        SecurityContextHolder.clearContext();  // Clear session
    }

}