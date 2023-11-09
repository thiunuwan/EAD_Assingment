package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.ShoppingCartItemsResquestDTO;
import com.thiunuwan.orderservice.service.ShoppingCartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shopping-cart-items")
@CrossOrigin(origins = {"*"})
public class ShoppingCartItemsController {

    @Autowired
    private ShoppingCartItemsService shoppingCartItemsService;

    @PostMapping("/add-cart-item")
    public ResponseEntity<String> addShoppingCartItem(@RequestBody ShoppingCartItemsResquestDTO shoppingCartItemsResquestDTO){
        String result = shoppingCartItemsService.saveShoppingCartItem(shoppingCartItemsResquestDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-cart-items")
    public ResponseEntity<List<ShoppingCartItemsResquestDTO>> getAllShoppingCartItems(){
        List<ShoppingCartItemsResquestDTO> shoppingCartItemsResquestDTOList = shoppingCartItemsService.getAllShoppingCartItems();
        return ResponseEntity.ok(shoppingCartItemsResquestDTOList);
    }


}
