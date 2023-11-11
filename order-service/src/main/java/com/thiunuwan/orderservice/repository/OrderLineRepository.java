//package com.thiunuwan.orderservice.repository;
//
//import com.thiunuwan.orderservice.entity.OrderLine;
//import com.thiunuwan.orderservice.entity.ShopOrder;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
////    @Query("SELECT O FROM OrderLine O WHERE O.order.id = :oid")
//    List<OrderLine> findByOrder_Id(Long oid);
//}
