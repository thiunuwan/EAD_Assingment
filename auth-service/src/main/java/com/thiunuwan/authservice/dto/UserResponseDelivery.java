package com.thiunuwan.authservice.dto;

import com.thiunuwan.authservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserResponseDelivery {
    private int userId;
    private String username;
    private String email;
    private String address;
    private String contactNo;
    private String firstName;
    private String lastName;
}
