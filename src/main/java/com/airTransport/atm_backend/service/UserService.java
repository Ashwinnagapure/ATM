package com.airTransport.atm_backend.service;


// importing UserDTO and LoginDTO
import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;

import java.util.List;


public interface UserService{
    List<UserDTO> getAllUsers();
    String registerUser(UserDTO userDTO);
    String loginUser(LoginDTO loginDTO);
    void logout();
}