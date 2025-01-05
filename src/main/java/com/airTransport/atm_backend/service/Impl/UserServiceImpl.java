package com.airTransport.atm_backend.service.Impl;


import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.User;
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

    @Override
    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return "Email is already taken!";
        }

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return "Username is already taken!";
        }

        User newUser = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
        User save= userRepository.save(newUser);

        Passenger passenger = new Passenger();
        passenger.setUserId(save.getUserId());
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