package com.thiunuwan.orderservice.dto;

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
public class OrderLineRequestDTO {
    private long orderId;
    private int inventoryItemId;
    private Integer quantity;
    private double unitPrice;
    private double subTotal;
}
