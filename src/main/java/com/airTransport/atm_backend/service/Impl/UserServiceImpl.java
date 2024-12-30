package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.model.enums.UserType;
import com.airTransport.atm_backend.repository.UserRepository;
import com.airTransport.atm_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchUser(Long userId) {
        return userRepository.searchUser(userId);
    }

    @Override
    public String removeUser(Long userId) {
        userRepository.deleteById(userId);
        return "User Removed Successfully!";
    }
    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "User updated Successfully!";
    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User Added Successfully!";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByType(UserType userType) {
        return userRepository.findByUserType(userType);
    }
}