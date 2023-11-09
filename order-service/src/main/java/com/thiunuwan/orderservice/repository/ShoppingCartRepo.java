package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
}
