package com.thiunuwan.authservice.service;

import com.thiunuwan.authservice.dto.LoginResponseDTO;
import com.thiunuwan.authservice.entity.ApplicationUser;
import com.thiunuwan.authservice.entity.Role;
import com.thiunuwan.authservice.repository.RoleRepository;
import com.thiunuwan.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  TokenService tokenService;

    public ApplicationUser registerUser(String username,String password){
        String encodedPassword=passwordEncoder.encode(password);
        Role userRole =roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(null,username,encodedPassword,authorities));
    }


    public LoginResponseDTO loginUser(String username,String password){

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );

            String token = tokenService.generateJwt(authentication);
            return  new LoginResponseDTO(userRepository.findByUsername(username).get(),token);

        }catch (AuthenticationException e){
            return  new LoginResponseDTO(null,"");
        }

    }


}
