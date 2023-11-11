package com.example.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "category")
    private List<InventoryItem> items=new ArrayList<>();

}
