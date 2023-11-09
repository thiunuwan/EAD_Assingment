package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentMethodRepo extends JpaRepository<UserPaymentMethod, Long> {
}
