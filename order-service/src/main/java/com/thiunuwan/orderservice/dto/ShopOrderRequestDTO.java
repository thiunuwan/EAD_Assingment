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
public class ShopOrderRequestDTO {
    private int userId;
    private LocalDateTime orderDateTime;
//    private Long paymentId;
    private String shippingAddress;
    private double orderTotal;
    private String orderStatus;
}
