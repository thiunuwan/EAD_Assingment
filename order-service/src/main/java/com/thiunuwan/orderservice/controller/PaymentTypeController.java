package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.entity.PaymentType;
import com.thiunuwan.orderservice.repository.PaymentTypeRepo;
import com.thiunuwan.orderservice.service.PaymentService;
import com.thiunuwan.orderservice.service.PaymentTypeService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1/payment-type")
@CrossOrigin(origins = {"*"})
public class PaymentTypeController {

    @Autowired
    private PaymentTypeRepo paymentTypeRepo;

    @Autowired
    private PaymentTypeService paymentTypeService;

    @PostMapping("/add-type")
    public ResponseEntity<String> savePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO){
        String result = paymentTypeService.savePaymentType(paymentTypeDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-types")
    public ResponseEntity<List<PaymentTypeDTO>> getAllPaymentTypes(){
        List<PaymentTypeDTO> paymentTypeDTOList = paymentTypeService.getAllPaymentTypes();
        return ResponseEntity.ok(paymentTypeDTOList);
    }

    @DeleteMapping("/delete-type/{typeId}")
    public ResponseEntity<String> deletePaymentType(@PathVariable long typeId){
        String result = paymentTypeService.deletePaymentType(typeId);
        return ResponseEntity.ok(result);
    }






}
