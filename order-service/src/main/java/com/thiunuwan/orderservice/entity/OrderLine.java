//package com.thiunuwan.orderservice.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.math.BigDecimal;
//
//@Data
//@Builder
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderLine {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private ShopOrder order;
//    @ManyToOne
//    @JoinColumn(name = "product_item_id")
////    private InventoryItem inventoryItem;
//    private BigDecimal quantity;
//    private BigDecimal totalPrice;
//}
