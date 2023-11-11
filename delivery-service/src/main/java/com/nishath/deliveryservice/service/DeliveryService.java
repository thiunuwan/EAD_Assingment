package com.nishath.deliveryservice.service;

import com.nishath.deliveryservice.client.AuthClient;
import com.nishath.deliveryservice.dto.UserResponseDelivery;
import com.nishath.deliveryservice.entity.DeliveryEntity;
import com.nishath.deliveryservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final AuthClient authClient;

    @Autowired
    private DeliveryRepository deliveryRepository;

    public String assignDeliveryPerson(int orderId, int deliveryPersonId) {

//        DeliveryEntity deliveryEntity=new DeliveryEntity();


        UserResponseDelivery userResponseDelivery=authClient.getUserDetails(deliveryPersonId);

        System.out.println("**");
        System.out.println(userResponseDelivery);
        System.out.println("**");


        // should get the contact no of user

//
//        deliveryEntity.setDeliveryPersonId(deliveryPersonId);
//        deliveryEntity.setOrderId(orderId);
//        deliveryEntity.setDeliveryPersonContactNo(userResponseDelivery.getContactNo());
//        deliveryEntity.setUserId();
//        deliveryEntity.setUserContactNo();



        return "delivery person successfully assigned ";
    }
}
