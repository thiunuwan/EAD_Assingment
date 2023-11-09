package com.thiunuwan.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPaymentMethodRequestDTO {
    private long id;
    private long user_id;
    private long payment_type_id;
    private String account_num;
    private YearMonth expiry_date;
    private boolean is_default;

}
