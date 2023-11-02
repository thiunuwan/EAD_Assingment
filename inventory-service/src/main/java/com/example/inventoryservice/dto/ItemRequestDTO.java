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
public class ItemRequestDTO {
    private String itemName;
    private String category;
    private String description;
    private String imageURL;
    private int availableQuantity;
    private double unitPrice;
}
