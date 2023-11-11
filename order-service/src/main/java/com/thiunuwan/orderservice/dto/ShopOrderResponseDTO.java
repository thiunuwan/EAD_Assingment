package com.thiunuwan.orderservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ShopOrderResponseDTO {
    private Long id;
    private int user;
    private LocalDateTime localDateTime;
//    private Payment payment;
    private String shippingAddress;
    private double orderTotal;
    private String orderStatus;
}
