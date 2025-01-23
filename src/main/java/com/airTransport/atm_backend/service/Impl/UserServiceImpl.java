package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Passenger;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.PassengerRepository;
import com.airTransport.atm_backend.repository.UserRepository;
import com.airTransport.atm_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(convertToDTO(user));
        }
        return userDTOList;
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already taken!");
        }
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        userRepository.save(newUser);
        return "User registered successfully!";
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null || !user.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Invalid email or password!");
        }

        // Map the User entity to a UserDTO and return
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        return userDTO;
    }


    @Override
    public void logout() {
        // Logic for logging out the user
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
        return convertToDTO(user);
    }



    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
