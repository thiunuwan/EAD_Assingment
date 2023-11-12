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

    @PutMapping("/set-delivery-status/{deliveryId}/{status}")
    public ResponseEntity<String> setStatus(@PathVariable int deliveryId, @PathVariable String status){
        String result= deliveryService.setStatus(deliveryId,status);
        return ResponseEntity.ok(result);
    }


}
