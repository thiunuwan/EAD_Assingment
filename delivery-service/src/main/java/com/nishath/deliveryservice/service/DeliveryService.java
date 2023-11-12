package com.nishath.deliveryservice.service;

import com.nishath.deliveryservice.client.AuthClient;
import com.nishath.deliveryservice.client.OrderClient;
import com.nishath.deliveryservice.client.OrderResponseDTO;
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

    private final OrderClient orderClient;

    @Autowired
    private DeliveryRepository deliveryRepository;

    public String assignDeliveryPerson(long orderId, int deliveryPersonId) {

        DeliveryEntity deliveryEntity=new DeliveryEntity();


        UserResponseDelivery userResponseDelivery=authClient.getUserDetails(deliveryPersonId);

        OrderResponseDTO orderResponseDTO = orderClient.getOrderById(orderId);

        deliveryEntity.setDeliveryPersonId(deliveryPersonId);
        deliveryEntity.setOrderId(orderId);
        deliveryEntity.setDeliveryPersonContactNo(userResponseDelivery.getContactNo());
        deliveryEntity.setUserId(orderResponseDTO.getUser());
        deliveryEntity.setShippingAddress(orderResponseDTO.getShippingAddress());
//

        UserResponseDelivery userResponseDelivery2=authClient.getUserDetails(orderResponseDTO.getUser());
        System.out.println(userResponseDelivery2);

        deliveryEntity.setUserContactNo(userResponseDelivery2.getContactNo());
        deliveryRepository.save(deliveryEntity);
        return "delivery person successfully assigned ";
    }
}
