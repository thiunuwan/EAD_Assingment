package com.thiunuwan.authservice.controller;


import com.thiunuwan.authservice.dto.LoginResponseDTO;
import com.thiunuwan.authservice.dto.RegistrationDTO;
import com.thiunuwan.authservice.entity.ApplicationUser;
import com.thiunuwan.authservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")

public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO){
        System.out.println("r-controller");
        return authenticationService.registerUser(registrationDTO.getUsername(),registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO loginUser){
        return authenticationService.loginUser(loginUser.getUsername(), loginUser.getPassword());
    }    //user login DTO


}
