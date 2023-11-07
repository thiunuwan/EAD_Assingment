package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodDTO;
import com.thiunuwan.orderservice.entity.UserPaymentMethod;
import com.thiunuwan.orderservice.repository.UserPaymentMethodRepo;
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
    UserPaymentMethodService userPaymentMethodService;

    @PostMapping("/save-payment-method")
    public ResponseEntity<String> saveUserPaymentMethod(@RequestBody UserPaymentMethodDTO userPaymentMethodDTO){
        String result = userPaymentMethodService.saveUserPaymentMethod(userPaymentMethodDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-payment-methods")
    public ResponseEntity<List<UserPaymentMethodDTO>> getAllUSerPaymentMethods(){
        List<UserPaymentMethodDTO> userPaymentMethodDTOList = userPaymentMethodService.getAllUserPaymentMethods();
        return ResponseEntity.ok(userPaymentMethodDTOList);
    }
}
