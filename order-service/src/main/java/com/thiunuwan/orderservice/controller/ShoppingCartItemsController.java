package com.thiunuwan.orderservice.controller;


import com.thiunuwan.orderservice.dto.ShoppingCartItemsResponseDTO;
import com.thiunuwan.orderservice.dto.ShoppingCartItemsResquestDTO;
import com.thiunuwan.orderservice.entity.ShoppingCartItems;
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

    @PostMapping("/add-cart-item/{userId}")
    public ResponseEntity<String> addShoppingCartItem(@RequestBody ShoppingCartItemsResquestDTO shoppingCartItemsResquestDTO,@PathVariable int userId){
        String result = shoppingCartItemsService.saveShoppingCartItem(shoppingCartItemsResquestDTO,userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-cart-items")
    public ResponseEntity<List<ShoppingCartItemsResponseDTO>> getAllShoppingCartItems(){
        List<ShoppingCartItemsResponseDTO> shoppingCartItemsResponseDTOList = shoppingCartItemsService.getAllShoppingCartItems();
        return ResponseEntity.ok(shoppingCartItemsResponseDTOList);
    }

    @GetMapping("/get-cart-item/{shopping_cart_id}")
    public ResponseEntity<List<ShoppingCartItemsResponseDTO>> getShoppingCartItemsByCartId(@PathVariable Long shopping_cart_id ){
        List<ShoppingCartItemsResponseDTO> shoppingCartItemsResponseDTOList = shoppingCartItemsService.getShoppingCartItemsByCartId(shopping_cart_id);
        return ResponseEntity.ok(shoppingCartItemsResponseDTOList);
    }


}
