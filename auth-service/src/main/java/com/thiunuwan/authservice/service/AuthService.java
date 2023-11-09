package com.thiunuwan.authservice.service;


import com.thiunuwan.authservice.entity.Role;
import com.thiunuwan.authservice.entity.UserCredential;
import com.thiunuwan.authservice.repository.RoleRepository;
import com.thiunuwan.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        Set<Role> roles= new HashSet<>();
        roles.add(roleRepository.findByAuthority("USER").get());
        credential.setAuthorities(roles);
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
