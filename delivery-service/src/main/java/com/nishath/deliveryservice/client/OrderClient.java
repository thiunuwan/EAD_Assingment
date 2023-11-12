package com.nishath.deliveryservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "order-service",url = "http://localhost:8091/api/v1/order")
public interface OrderClient {

    @GetMapping("getOrder/{id}")
   OrderResponseDTO getOrderById(@PathVariable(name = "id") Long orderId);

}
