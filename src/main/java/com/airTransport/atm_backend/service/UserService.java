package com.airTransport.atm_backend.service;
import com.airTransport.atm_backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService{
    public User searchUser(Long userId);
    public String removeUser(Long userId);
    public String updateUser(User user);
    public String createUser(User user);
    public List<User> getAllUsers();
}
