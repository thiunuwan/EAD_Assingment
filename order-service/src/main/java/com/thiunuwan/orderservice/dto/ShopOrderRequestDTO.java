package com.thiunuwan.orderservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ShopOrderRequestDTO {
    private Long userId;
    private LocalDate orderDate;
    private Long paymentId;
    private String shippingAddress;
    private BigDecimal orderTotal;
    private String orderStatus;
}
