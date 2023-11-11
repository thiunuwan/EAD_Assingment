package com.nishath.deliveryservice.client;


import com.nishath.deliveryservice.dto.UserResponseDelivery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service",url = "http://localhost:8090/auth/user")
public interface AuthClient {

    @GetMapping("/userById/{id}")
    UserResponseDelivery getUserDetails(@PathVariable int id);

}
