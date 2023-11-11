package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.ShoppingCartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartItemsRepo extends JpaRepository<ShoppingCartItems,Long> {

    @Query("SELECT s FROM ShoppingCartItems s WHERE s.shoppingCart.id = ?1")
    List<ShoppingCartItems> findByShopping_cart_id(Long shopping_cart_id);
}
