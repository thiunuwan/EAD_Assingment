package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.PaymentRequestDTO;
import com.thiunuwan.orderservice.dto.PaymentResponseDTO;
import com.thiunuwan.orderservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/payment")
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO responseDTO = paymentService.initiatePayment(paymentRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

}
