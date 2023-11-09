package com.thiunuwan.orderservice.dto;

import com.thiunuwan.orderservice.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemsResponseDTO {
    private Long id;
    private ShoppingCart shoppingCart;
//        private set<Item> item;
    private Integer qty;
}