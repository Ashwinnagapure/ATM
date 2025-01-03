package com.airTransport.atm_backend.service;


// importing UserDTO and LoginDTO
import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;


public interface UserService{
    String registerUser(UserDTO userDTO);
    String loginUser(LoginDTO loginDTO);
    void logout();
}