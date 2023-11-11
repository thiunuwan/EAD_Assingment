package com.thiunuwan.orderservice.dto;

import com.thiunuwan.orderservice.entity.ShopOrder;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class OrderLineResponseDTO {
    private Long id;
    private Long orderId;
//    private InventoryItem inventoryItem;
    private int inventoryItemId;
    private Integer quantity;
    private double subTotal;
}
