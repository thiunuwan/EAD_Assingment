package com.example.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String category;
    private String description;
    private String imageURL;
    private int availableQuantity;
    private double unitPrice;
}
