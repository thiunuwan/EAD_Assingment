//package com.thiunuwan.orderservice.repository;
//
//import com.thiunuwan.orderservice.entity.ShopOrder;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ShopOrderRepository extends JpaRepository<ShopOrder,Long> {
//    @Query("SELECT O FROM ShopOrder O WHERE O.user.id = :uid")
//    List<ShopOrder> findByUserId(int uid);
//}
