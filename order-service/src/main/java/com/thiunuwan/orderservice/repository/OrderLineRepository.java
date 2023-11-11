package com.thiunuwan.orderservice.repository;

import com.thiunuwan.orderservice.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
   // @Query("SELECT O FROM OrderLine O WHERE O.orderId = :oid")
    List<OrderLine> findByOrderId(Long oid);
}
