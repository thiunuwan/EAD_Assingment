package com.nishath.deliveryservice.client;

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
public class OrderResponseDTO {
    private Long id;
    private int user;
    private LocalDateTime localDateTime;
    //    private Payment payment;
    private String shippingAddress;
    private double orderTotal;
    private String orderStatus;
}
