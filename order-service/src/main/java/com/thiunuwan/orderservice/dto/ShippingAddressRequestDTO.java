package com.thiunuwan.orderservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ShippingAddressRequestDTO {
    String shippingAddress;
}
