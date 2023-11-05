package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.entity.PaymentType;
import com.thiunuwan.orderservice.repository.PaymentTypeRepo;
import com.thiunuwan.orderservice.service.PaymentService;
import com.thiunuwan.orderservice.service.PaymentTypeService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1/payment-type")
@CrossOrigin(origins = {"*"})
public class PaymentTypeController {

    @Autowired
    PaymentTypeRepo paymentTypeRepo;

    @Autowired
    PaymentTypeService paymentTypeService;

    @PostMapping("/add-type")
    public String savePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO){
        return paymentTypeService.savePaymentType(paymentTypeDTO);
    }

    @GetMapping("/types")
    List<PaymentType> getAllPaymentTypes(){
        return paymentTypeRepo.findAll();
    }

}
