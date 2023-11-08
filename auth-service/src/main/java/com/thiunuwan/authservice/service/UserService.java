package com.thiunuwan.authservice.service;

import com.thiunuwan.authservice.dto.UserResponse;
import com.thiunuwan.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserCredentialRepository repository;


    public UserResponse getUserDetailsByUsername(String username) {
        return  null;
    }

    public List<UserResponse> getAllUsersByRole(String role) {
        return  null;
    }
}
