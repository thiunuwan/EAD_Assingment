package com.thiunuwan.orderservice.service;

import com.stripe.model.Order;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public String createOrder(ShopOrderRequestDTO shopOrderRequestDTO) {
        User user = userRepository.findById(shopOrderRequestDTO.getUserId()).orElse(null);
        Payment payment = paymentRepository.findById(shopOrderRequestDTO.getPaymentId()).orElse(null);

        ShopOrder newshopOrder = ShopOrder.builder()
                .user(user)
                .orderDate(shopOrderRequestDTO.getOrderDate())
                .payment(payment)
                .shippingAddress(shopOrderRequestDTO.getShippingAddress())
                .orderTotal(shopOrderRequestDTO.getOrderTotal())
                .orderStatus(shopOrderRequestDTO.getOrderStatus())
                .build();
        shopOrderRepository.save(newshopOrder);
        return "Order Created Successfully";
    }

    @Override
    public ShopOrderResponseDTO getOrderById(Long orderId) {
        ShopOrder shopOrderEntity=shopOrderRepository.findById(orderId).orElse(null);
        ShopOrderResponseDTO shopOrderResponseDTO= ShopOrderResponseDTO.builder()
                .id(shopOrderEntity.getId())
                .user(shopOrderEntity.getUser())
                .orderDate(shopOrderEntity.getOrderDate())
                .payment(shopOrderEntity.getPayment())
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
                    .user(shopOrder.getUser())
                    .orderDate(shopOrder.getOrderDate())
                    .payment(shopOrder.getPayment())
                    .shippingAddress(shopOrder.getShippingAddress())
                    .orderTotal(shopOrder.getOrderTotal())
                    .orderStatus(shopOrder.getOrderStatus())
                    .build();
            shopOrderResponseDTOS.add(responseDTO);
        }
        return shopOrderResponseDTOS;
    }
}
responseDTO.setId(shopOrder.getId());
        responseDTO.setUser(shopOrder.getUser());
        responseDTO.setOrderDate(shopOrder.getOrderDate());
        responseDTO.setPayment(shopOrder.getPayment());
        responseDTO.setShippingAddress(shopOrder.getShippingAddress());
        responseDTO.setOrderTotal(shopOrder.getOrderTotal());
        responseDTO.setOrderStatus(shopOrder.getOrderStatus());
        shopOrderResponseDTOS.add(responseDTO);