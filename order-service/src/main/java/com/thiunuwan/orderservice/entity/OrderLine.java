package com.thiunuwan.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private int inventoryItemId;
    private Integer quantity;
    private double subTotal;

//    @ManyToOne
//    @JoinColumn(name = "product_item_id")
//    private InventoryItem inventoryItem;

}
