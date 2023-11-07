package com.thiunuwan.orderservice.dto;


import com.thiunuwan.orderservice.entity.PaymentType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPaymentMethodDTO {
    private long id;
    private long user_id;
    private PaymentType paymentType;
    private String account_num;
    private YearMonth expiry_date;
    private boolean is_default;

}
