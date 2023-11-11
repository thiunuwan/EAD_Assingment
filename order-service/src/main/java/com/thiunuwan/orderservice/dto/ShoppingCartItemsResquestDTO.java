package com.thiunuwan.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemsResquestDTO {

    private Integer item_id;
    private Integer qty;
    private Double price;

}
