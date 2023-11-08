package com.thiunuwan.authservice.controller;

import com.thiunuwan.authservice.dto.UserResponse;
import com.thiunuwan.authservice.entity.UserCredential;
import com.thiunuwan.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public UserResponse getUserDetails(@PathVariable String username) {
        return userService.getUserDetailsByUsername(username);
    }

    @GetMapping("/usersByRole/{role}")
    public List<UserResponse> getAllUsersByRole(@PathVariable String role) {
        return userService.getAllUsersByRole(role);
    }
}
