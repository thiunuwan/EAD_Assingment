package com.thiunuwan.orderservice.service;

import com.thiunuwan.orderservice.dto.ShopOrderRequestDTO;
import com.thiunuwan.orderservice.dto.ShopOrderResponseDTO;

import java.util.List;

public interface ShopOrderService {
   Long createOrder(ShopOrderRequestDTO shopOrderRequestDTO);

    ShopOrderResponseDTO getOrderById(Long orderId);

    String updateOrderStatus(Long orderId, String newStatus);

    List<ShopOrderResponseDTO> getOrdersByUid(int uid);
}
