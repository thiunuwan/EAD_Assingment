package com.thiunuwan.authservice.service;

import com.thiunuwan.authservice.entity.ApplicationUser;
import com.thiunuwan.authservice.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("inside user detail service");
        if(!username.equals("tnuwan")) throw  new UsernameNotFoundException("Not correct user");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"USER"));
        return new ApplicationUser(1,"tnuwan",encoder.encode("password"),roles);
    }
}
