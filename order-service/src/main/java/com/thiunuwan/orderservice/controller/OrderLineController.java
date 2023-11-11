package com.thiunuwan.orderservice.controller;

import com.thiunuwan.orderservice.dto.OrderLineRequestDTO;
import com.thiunuwan.orderservice.dto.OrderLineResponseDTO;
import com.thiunuwan.orderservice.service.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderLine")
public class OrderLineController {
    @Autowired
    private OrderLineServiceImpl orderLineServiceImpl;

//    @PostMapping("/addOrderLine")
//    public ResponseEntity<String> addOrderLine(@RequestBody OrderLineRequestDTO orderLineRequestDTO) {
//        String status = orderLineServiceImpl.addOrderLine(orderLineRequestDTO);
//        return ResponseEntity.ok(status);
//    }

    @GetMapping("/getOrderLineList/{oid}")
    public ResponseEntity<List<OrderLineResponseDTO>> getOrderLineList(@PathVariable(name = "oid") Long oid){
        List<OrderLineResponseDTO> orderLineResponseDTOList = orderLineServiceImpl.getOrderLineList(oid);
        return ResponseEntity.ok(orderLineResponseDTOList);
    }


}
