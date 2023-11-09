package com.thiunuwan.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    private String address;
    private String contactNo;
    private String firstName;
    private String lastName;

}
