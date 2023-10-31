package com.example.inventoryservice.dto;


import lombok.*;
import org.springframework.stereotype.Component;



@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProductRequestDTO {
    private String category;
    private String description;
    private String imageURL;
    private int quantity;
    private double price;
}