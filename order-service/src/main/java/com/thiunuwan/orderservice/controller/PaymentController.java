package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.DeductItemsResponseDTO;
import com.thiunuwan.orderservice.dto.PaymentRequestDTO;
import com.thiunuwan.orderservice.dto.PaymentResponseDTO;
import com.thiunuwan.orderservice.dto.ShippingAddressRequestDTO;
import com.thiunuwan.orderservice.service.PaymentService;
import com.thiunuwan.orderservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO responseDTO = paymentService.initiatePayment(paymentRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/isPaymentSuccessful/{code}/{userId}")
    public ResponseEntity<Integer> isPaymentSuccessful(@PathVariable int code,@PathVariable int userId,@RequestBody ShippingAddressRequestDTO shippingAddressRequestDTO){
        return ResponseEntity.ok(paymentService.isPaymentSuccessful(code,userId, shippingAddressRequestDTO.getShippingAddress()));
    }








}
