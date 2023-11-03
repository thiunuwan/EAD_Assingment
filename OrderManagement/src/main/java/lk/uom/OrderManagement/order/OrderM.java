package lk.uom.OrderManagement.order;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class OrderM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String uniqId;

    private String customerId;
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'processing'")
    private String status;



    @Column(columnDefinition = "DATETIME")
    private LocalDateTime createdDate;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean paid;

    public OrderM() {
    }

    public OrderM(String customerId) {
        this.uniqId = UUID.randomUUID().toString();
       this.createdDate = LocalDateTime.now();
       this.customerId = customerId;
       this.paid = false;
       this.status = "processing";
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getUniqId() {
        return uniqId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
