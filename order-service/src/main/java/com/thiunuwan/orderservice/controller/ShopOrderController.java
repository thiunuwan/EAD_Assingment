//package com.thiunuwan.orderservice.controller;
//
//import com.thiunuwan.orderservice.dto.ShopOrderRequestDTO;
//import com.thiunuwan.orderservice.dto.ShopOrderResponseDTO;
//import com.thiunuwan.orderservice.service.ShopOrderServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/order")
//public class ShopOrderController {
//    @Autowired
//    private ShopOrderServiceImpl shopOrderServiceImpl;
//
//    @PostMapping("/createOrder")
//    public ResponseEntity<String> createOrder(@RequestBody ShopOrderRequestDTO shopOrderRequestDTO){
//        String status = shopOrderServiceImpl.createOrder(shopOrderRequestDTO);
//        return ResponseEntity.ok(status);
//    }
//
//    @GetMapping("getOrder/{id}")
//    public ResponseEntity<ShopOrderResponseDTO> getOrderById(@PathVariable(name = "id") Long orderId){
//        ShopOrderResponseDTO shopOrderResponse = shopOrderServiceImpl.getOrderById(orderId);
//        return ResponseEntity.ok(shopOrderResponse);
//    }
//
//    @PutMapping("updateOrder/{id}/{status}")
//    public ResponseEntity<String> updateOrderStatus(@PathVariable(name = "id") Long orderId, @PathVariable(name = "status") String newStatus){
//        String status = shopOrderServiceImpl.updateOrderStatus(orderId,newStatus);
//        return ResponseEntity.ok(status);
//    }
//
//    @GetMapping("getOrderList/{uid}")
//    public ResponseEntity<List<ShopOrderResponseDTO>> getOrdersByUid(@PathVariable(name="uid") int uid){
//        List<ShopOrderResponseDTO> shopOrderResponseDTOList = shopOrderServiceImpl.getOrdersByUid(uid);
//        return ResponseEntity.ok(shopOrderResponseDTOList);
//    }
//}
