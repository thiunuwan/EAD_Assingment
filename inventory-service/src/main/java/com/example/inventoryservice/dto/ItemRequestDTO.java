package com.example.inventoryservice.dto;


import com.example.inventoryservice.entity.Category;
import com.example.inventoryservice.entity.Unit;
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
    private Category category;
    private String description;
    private String imageURL;
    private int availableQuantity;
    private double unitPrice;
    private Unit unit;
}
