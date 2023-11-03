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
public class ItemResponseDTO {
    private int itemId;
    private String itemName;
    private String description;
    private String imageURL;
    private int availableQuantity;
    private double unitPrice;
    private Unit unit;
    private Category category;
}
