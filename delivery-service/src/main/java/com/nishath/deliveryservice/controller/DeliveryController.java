package com.nishath.deliveryservice.controller;

import com.nishath.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/assign-deliveryPerson/{orderId}/{deliveryPersonId}")
    public ResponseEntity<String> assignDeliveryPerson(@PathVariable int orderId, @PathVariable int deliveryPersonId){
        String result= deliveryService.assignDeliveryPerson(orderId,deliveryPersonId);
        return ResponseEntity.ok(result);
    }


}
