package com.thiunuwan.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    private int userId;

    @Column(name = "order_date")
    private LocalDateTime orderDateTime;

//    @OneToOne
//    @JoinColumn(name = "payment_id")
//    private Payment payment;

    @JoinColumn(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "order_total")
    private double orderTotal;

    @JoinColumn(name = "order_status")
    private String orderStatus;
}
