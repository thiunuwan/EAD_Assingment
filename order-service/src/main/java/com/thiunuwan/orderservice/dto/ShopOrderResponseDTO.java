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
public class ShopOrderResponseDTO {
    private Long id;
    private User user;
    private LocalDate orderDate;
    private Payment payment;
    private String shippingAddress;
    private BigDecimal orderTotal;
    private String orderStatus;
}
