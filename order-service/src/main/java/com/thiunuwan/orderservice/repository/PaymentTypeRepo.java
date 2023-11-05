package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentTypeRepo extends JpaRepository<PaymentType, Long> {

    @Query( value = "SELECT * FROM payment_type WHERE payment_type=?1" ,nativeQuery = true)
    boolean getPaymentTypeByType(String paymentType);
}
