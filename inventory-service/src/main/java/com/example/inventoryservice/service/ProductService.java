package com.example.inventoryservice.service;


import com.example.inventoryservice.dto.ProductRequestDTO;
import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public String addProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct=Product.builder()
                .category(productRequestDTO.getCategory())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .imageURL(productRequestDTO.getImageURL())
                .quantity(productRequestDTO.getQuantity())
                .build();

        ;
        productRepository.save(newProduct);
        return  "Product is successfully added to the inventory";
    }
}
