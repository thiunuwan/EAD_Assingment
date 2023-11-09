package com.thiunuwan.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemsDTO {

    private Long id;
    private Long shopping_cart_id;
//    private Long item_id;
    private int qty;

}
