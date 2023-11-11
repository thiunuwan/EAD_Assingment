package com.thiunuwan.authservice.controller;

import com.thiunuwan.authservice.dto.UserResponse;
import com.thiunuwan.authservice.entity.UserCredential;
import com.thiunuwan.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{username}")
    public UserResponse getUserDetails(@PathVariable String username) {
        return userService.getUserDetailsByUsername(username);
    }

    @GetMapping("/usersByRole/{roleId}")
    public List<UserResponse> getAllUsersByRole(@PathVariable int roleId) {
        return userService.getAllUsersByRole(roleId);
    }


    @PutMapping("/{username}/set-role/{roleId}")
    public UserResponse setRoles(@PathVariable String username,@PathVariable int roleId) {

        return userService.setRoles(username,roleId);
    }


}
