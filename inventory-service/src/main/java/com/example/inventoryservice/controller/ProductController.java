package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.ProductRequestDTO;
import com.example.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        String result=productService.addProduct(productRequestDTO);
        return ResponseEntity.ok(result);
    }


}
