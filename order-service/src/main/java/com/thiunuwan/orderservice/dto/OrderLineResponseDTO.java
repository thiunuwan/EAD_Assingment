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
    private ShopOrder order;
    private InventoryItem inventoryItem;
    private BigDecimal quantity;
    private BigDecimal totalPrice;
}
