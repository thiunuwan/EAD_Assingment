package com.nishath.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
