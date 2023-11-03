package lk.uom.OrderManagement.order;

import jakarta.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerid;
    private String productid;

    public Cart() {
    }

    public Cart(String customerid, String productid) {
        this.customerid = customerid;
        this.productid = productid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getProductid() {
        return productid;
    }
}
