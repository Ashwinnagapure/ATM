package com.airTransport.atm_backend.service.Impl;
import java.util.ArrayList;
import java.util.List;

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


    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();  // Fetch all users from DB
        List<UserDTO> userDTOList = new ArrayList<>();

        // Convert each user entity to a UserDTO
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setUsername(user.getUsername());
            userDTO.setRole(user.getRole());
            // Add other fields if needed
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            System.out.println("Email is already taken!");
            return "false";
        }

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            System.out.println("Username is already taken!");
            return "false";
        }

        User newUser = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
        User save= userRepository.save(newUser);

        Passenger passenger = new Passenger();
        passenger.setUserId(save.getUserId());
        System.out.println("Registration successful");
        return "true";
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            System.out.println("Login successful");
            return "true";
        } else {
            System.out.println("Invalid username or password!");
            return "false";
//            return "Invalid username or password!";
        }
    }

    @Override
    public void logout() {

        System.out.println("Logout successful");
        SecurityContextHolder.clearContext();  // Clear session
    }

}