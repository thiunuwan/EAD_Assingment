package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.ProductRequestDTO;
import com.example.inventoryservice.dto.ProductResponseDTO;
import com.example.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        String result=productService.addProduct(productRequestDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-products")
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size
    ) {

        ResponseEntity<Page<ProductResponseDTO>> responseEntity = null;

        Page<ProductResponseDTO> pageDTOs = productService.getAllProducts(page, size);
        return responseEntity.ok(pageDTOs);
    }

}
