package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.dto.ShoppingCartDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodDTO;
import com.thiunuwan.orderservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shopping-cart")
@CrossOrigin(origins = {"*"})
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/save-cart")
    public ResponseEntity<String> saveShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
        String result = shoppingCartService.saveShoppingCart(shoppingCartDTO);
        return ResponseEntity.ok(result);
    }

}
