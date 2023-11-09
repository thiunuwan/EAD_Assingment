package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.ShoppingCartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemsRepo extends JpaRepository<ShoppingCartItems,Long> {
}
