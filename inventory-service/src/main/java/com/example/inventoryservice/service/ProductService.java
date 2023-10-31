package com.example.inventoryservice.service;


import com.example.inventoryservice.dto.ProductRequestDTO;
import com.example.inventoryservice.dto.ProductResponseDTO;
import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Page<ProductResponseDTO> getAllProducts(Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Product> pageEntities = productRepository.findAll(pageable);

        List<Product> entityList = pageEntities.getContent();
        List<ProductResponseDTO> dtoList = new ArrayList<>();

        entityList.forEach(entity -> dtoList.add(convertToProductResponse(entity)));

        return new PageImpl<>(dtoList, pageable, pageEntities.getTotalElements());
    }

    private ProductResponseDTO convertToProductResponse(Product entity) {
        ProductResponseDTO productResponseDTO=ProductResponseDTO.builder()
                                                                .category(entity.getCategory())
                                                                .quantity(entity.getQuantity())
                                                                .price(entity.getPrice())
                                                                .id(entity.getId())
                                                                .description(entity.getDescription())
                                                                .imageURL(entity.getImageURL())
                                                                .build();
        return productResponseDTO;
    }
}
