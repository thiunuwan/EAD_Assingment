package com.thiunuwan.authservice.controller;

import com.thiunuwan.authservice.dto.UserResponse;
import com.thiunuwan.authservice.entity.UserCredential;
import com.thiunuwan.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public UserResponse getUserDetails(@PathVariable String username) {
        return userService.getUserDetailsByUsername(username);
    }

    @GetMapping("/usersByRole/{role}")
    public List<UserResponse> getAllUsersByRole(@PathVariable int roleId) {
        return userService.getAllUsersByRole(roleId);
    }


    @PostMapping("/user/{username}/set-role/{roleId}")
    public UserResponse setRoles(@PathVariable String username,@PathVariable int roleId) {

        return userService.setRoles(username,roleId);
    }


}
