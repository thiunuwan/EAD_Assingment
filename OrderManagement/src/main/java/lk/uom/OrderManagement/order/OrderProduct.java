package lk.uom.OrderManagement.order;

import jakarta.persistence.*;

@Entity
@Table
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String orderId;

    @Column(columnDefinition = "VARCHAR(50)")
    private String productId;

    public OrderProduct(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
