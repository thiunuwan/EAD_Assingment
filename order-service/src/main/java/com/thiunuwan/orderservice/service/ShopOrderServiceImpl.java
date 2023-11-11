package com.thiunuwan.orderservice.service;

import com.thiunuwan.orderservice.dto.ShopOrderRequestDTO;
import com.thiunuwan.orderservice.dto.ShopOrderResponseDTO;
import com.thiunuwan.orderservice.entity.ShopOrder;
import com.thiunuwan.orderservice.repository.ShopOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService{
    @Autowired
    private ShopOrderRepository shopOrderRepository;


    @Override
    public Long createOrder(ShopOrderRequestDTO shopOrderRequestDTO) {

        ShopOrder newshopOrder = ShopOrder.builder()
                .userId(shopOrderRequestDTO.getUserId())
                .orderDateTime(shopOrderRequestDTO.getOrderDateTime())
                .shippingAddress(shopOrderRequestDTO.getShippingAddress())
                .orderTotal(shopOrderRequestDTO.getOrderTotal())
                .orderStatus(shopOrderRequestDTO.getOrderStatus())
                .build();
        shopOrderRepository.save(newshopOrder);
        return  newshopOrder.getId();
    }

    @Override
    public ShopOrderResponseDTO getOrderById(Long orderId) {
        ShopOrder shopOrderEntity=shopOrderRepository.findById(orderId).orElse(null);
        ShopOrderResponseDTO shopOrderResponseDTO= ShopOrderResponseDTO.builder()
                .id(shopOrderEntity.getId())
                .user(shopOrderEntity.getUserId())
                .localDateTime(shopOrderEntity.getOrderDateTime())
                .shippingAddress(shopOrderEntity.getShippingAddress())
                .orderTotal(shopOrderEntity.getOrderTotal())
                .orderStatus(shopOrderEntity.getOrderStatus())
                .build();
        return shopOrderResponseDTO;
    }

    @Override
    public String updateOrderStatus(Long orderId, String newStatus) {
        ShopOrder order = shopOrderRepository.findById(orderId).orElse(null);
        order.setOrderStatus(newStatus);
        shopOrderRepository.save(order);
        return "Order Status updated Successfully";
    }

    @Override
    public List<ShopOrderResponseDTO> getOrdersByUid(int uid) {
        List<ShopOrder> shopOrderList = shopOrderRepository.findByUserId(uid);
        List<ShopOrderResponseDTO> orderResponseDTOList = mapOrdersToOrderResponseDTOs(shopOrderList);
        return orderResponseDTOList;
    }

    private List<ShopOrderResponseDTO> mapOrdersToOrderResponseDTOs(List<ShopOrder> shopOrderList) {
        List<ShopOrderResponseDTO> shopOrderResponseDTOS = new ArrayList<>();
        for(ShopOrder shopOrder :shopOrderList){
            ShopOrderResponseDTO responseDTO = ShopOrderResponseDTO.builder()
                    .id(shopOrder.getId())
                    .user(shopOrder.getUserId())
                    .localDateTime(shopOrder.getOrderDateTime())
                    .shippingAddress(shopOrder.getShippingAddress())
                    .orderTotal(shopOrder.getOrderTotal())
                    .orderStatus(shopOrder.getOrderStatus())
                    .build();
            shopOrderResponseDTOS.add(responseDTO);
        }
        return shopOrderResponseDTOS;
    }
}
