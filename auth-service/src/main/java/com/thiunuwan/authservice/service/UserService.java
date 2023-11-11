package com.thiunuwan.authservice.service;

import com.thiunuwan.authservice.dto.UserResponse;
import com.thiunuwan.authservice.entity.Role;
import com.thiunuwan.authservice.entity.UserCredential;
import com.thiunuwan.authservice.repository.RoleRepository;
import com.thiunuwan.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private RoleRepository roleRepository;


    public UserResponse getUserDetailsByUsername(String username) {
        UserCredential userEntity=repository.findByUsername(username).get();
        UserResponse userResponseDTO=UserResponse.builder()
                .username(userEntity.getUsername())
                .userId(userEntity.getUser_id())
                .email(userEntity.getEmail())
                .address(userEntity.getAddress())
                .authorities(userEntity.getAuthorities())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .contactNo(userEntity.getContactNo())
                .build();
        return  userResponseDTO;
    }

    public List<UserResponse> getAllUsersByRole(int roleId) {

        List<UserCredential> userEntityList=repository.findUsersByRoleId(roleId);
        List<UserResponse> userResponseDTOList=new ArrayList<>();
        for(UserCredential userEntity:userEntityList){
            UserResponse userResponseDTO=UserResponse.builder()
                    .username(userEntity.getUsername())
                    .userId(userEntity.getUser_id())
                    .email(userEntity.getEmail())
                    .address(userEntity.getAddress())
                    .authorities(userEntity.getAuthorities())
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .contactNo(userEntity.getContactNo())
                    .build();
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    public UserResponse setRoles(String username, int roleId) {
        UserCredential userEntity=repository.findByUsername(username).get();
        Set<Role> roles=userEntity.getAuthorities();
        Role newRole=roleRepository.findById(roleId).orElse(null);
        roles.add(newRole);

        userEntity.setAuthorities(roles);
        repository.save(userEntity);

        UserResponse userResponseDTO=UserResponse.builder()
                .userId(userEntity.getUser_id())
                .email(userEntity.getEmail())
                .address(userEntity.getAddress())
                .authorities(userEntity.getAuthorities())    //**********************************
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .contactNo(userEntity.getContactNo())
                .build();
        return  userResponseDTO;
    }
}
