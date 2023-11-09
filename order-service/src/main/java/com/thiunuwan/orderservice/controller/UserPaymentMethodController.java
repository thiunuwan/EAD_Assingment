package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.UserPaymentMethodRequestDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodResponseDTO;
import com.thiunuwan.orderservice.service.UserPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1/payment-method")
@CrossOrigin(origins = {"*"})
public class UserPaymentMethodController {

    @Autowired
    private UserPaymentMethodService userPaymentMethodService;

    @PostMapping("/save-payment-method")
    public ResponseEntity<String> saveUserPaymentMethod(@RequestBody UserPaymentMethodRequestDTO userPaymentMethodRequestDTO){
        String result = userPaymentMethodService.saveUserPaymentMethod(userPaymentMethodRequestDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-payment-methods")
    public ResponseEntity<List<UserPaymentMethodResponseDTO>> getAllUSerPaymentMethods(){
        List<UserPaymentMethodResponseDTO> userPaymentMethodResponseDTOList = userPaymentMethodService.getAllUserPaymentMethods();
        return ResponseEntity.ok(userPaymentMethodResponseDTOList);
    }
}
