//package com.thiunuwan.orderservice.service;
//
//import com.thiunuwan.orderservice.dto.OrderLineRequestDTO;
//import com.thiunuwan.orderservice.dto.OrderLineResponseDTO;
//import com.thiunuwan.orderservice.dto.ShopOrderResponseDTO;
//import com.thiunuwan.orderservice.entity.OrderLine;
//import com.thiunuwan.orderservice.entity.ShopOrder;
//import com.thiunuwan.orderservice.repository.OrderLineRepository;
//import com.thiunuwan.orderservice.repository.ShopOrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;

//@Service
//public class OrderLineServiceImpl implements OrderLineService{
//    @Autowired
//    private OrderLineRepository orderLineRepository;
//    @Autowired
//    private ShopOrderRepository shopOrderRepository;
//    @Autowired
//    private ItemRepository itemRepository;
//    @Override
//    public String addOrderLine(OrderLineRequestDTO orderLineRequestDTO) {
//        ShopOrder shopOrder = shopOrderRepository.findById(orderLineRequestDTO.getOrderId()).orElse(null);
//        InventoryItem inventoryitem = itemRepository.findById(orderLineRequestDTO.getInventoryItemId()).orElse(null);
//
//        OrderLine neworderLine = OrderLine.builder()
//                .order(shopOrder)
//                .inventoryItem(inventoryitem)
//                .quantity(orderLineRequestDTO.getQuantity())
//                .totalPrice(orderLineRequestDTO.getTotalPrice())
//                .build();
//        orderLineRepository.save(neworderLine);
//        return "OrderLine Added Successfully";
//    }
//
//    @Override
//    public List<OrderLineResponseDTO> getOrderLineList(Long oid) {
//        List<OrderLine> orderLineList=orderLineRepository.findByOrder_Id(oid);
//        List<OrderLineResponseDTO> orderLineResponseDTOList = mapOrderLinesToOrderLineResponseDTOs(orderLineList);
//
//        return orderLineResponseDTOList;
//    }
//
//    private List<OrderLineResponseDTO> mapOrderLinesToOrderLineResponseDTOs(List<OrderLine> orderLineList) {
//        List<OrderLineResponseDTO> OrderLineResponseDTOS = new ArrayList<>();
//        for(OrderLine orderLine :orderLineList){
//            OrderLineResponseDTO responseDTO = OrderLineResponseDTO.builder()
//                    .id(orderLine.getId())
//                    .order(orderLine.getOrder())
//                    .inventoryItem(orderLine.getInventoryItem())
//                    .quantity(orderLine.getQuantity())
//                    .totalPrice(orderLine.getTotalPrice())
//                    .build();
//            OrderLineResponseDTOS.add(responseDTO);
//        }
//        return OrderLineResponseDTOS;
//    }
//
//}
