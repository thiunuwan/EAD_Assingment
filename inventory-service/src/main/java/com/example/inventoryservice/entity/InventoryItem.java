package com.example.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(unique = true)
    private String itemName;
    private String description;
    private String imageURL;
    private int availableQuantity;
    private double unitPrice;
    @Enumerated(EnumType.STRING)
    private  Unit unit;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "category-id")
    private Category category;

}
