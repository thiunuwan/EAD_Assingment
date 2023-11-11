package com.thiunuwan.orderservice.service;

import com.thiunuwan.orderservice.dto.OrderLineRequestDTO;
import com.thiunuwan.orderservice.dto.OrderLineResponseDTO;
import com.thiunuwan.orderservice.entity.OrderLine;
import com.thiunuwan.orderservice.repository.OrderLineRepository;
import com.thiunuwan.orderservice.repository.ShopOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService{
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private ShopOrderRepository shopOrderRepository;

    @Override
    public String addOrderLine(OrderLineRequestDTO orderLineRequestDTO) {


        OrderLine neworderLine = OrderLine.builder()
                .orderId(orderLineRequestDTO.getOrderId())
                .inventoryItemId(orderLineRequestDTO.getInventoryItemId())
                .quantity(orderLineRequestDTO.getQuantity())
                .subTotal(orderLineRequestDTO.getSubTotal())
                .build();
        orderLineRepository.save(neworderLine);
        return "OrderLine Added Successfully";
    }

    @Override
    public List<OrderLineResponseDTO> getOrderLineList(Long oid) {
        List<OrderLine> orderLineList=orderLineRepository.findByOrderId(oid);
        List<OrderLineResponseDTO> orderLineResponseDTOList = mapOrderLinesToOrderLineResponseDTOs(orderLineList);

        return orderLineResponseDTOList;
    }

    private List<OrderLineResponseDTO> mapOrderLinesToOrderLineResponseDTOs(List<OrderLine> orderLineList) {
        List<OrderLineResponseDTO> OrderLineResponseDTOS = new ArrayList<>();
        for(OrderLine orderLine :orderLineList){
            OrderLineResponseDTO responseDTO = OrderLineResponseDTO.builder()
                    .id(orderLine.getId())
                    .orderId(orderLine.getOrderId())
                    .inventoryItemId(orderLine.getInventoryItemId())
                    .quantity(orderLine.getQuantity())
                    .subTotal(orderLine.getSubTotal())
                    .build();
            OrderLineResponseDTOS.add(responseDTO);
        }
        return OrderLineResponseDTOS;
    }

}
