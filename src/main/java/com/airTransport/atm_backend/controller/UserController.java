package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/search")
    public User getUserDetailsById(

            @RequestParam("userId") Long userId) {
        return userService.searchUser(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping
    public String editUser(@RequestBody User user) {
        userService.updateUser(user);
        return "User updated Successfully!";
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.createUser(user);
        return "User added Successfully!";
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
        return "User Deleted Successfully";
    }

}
