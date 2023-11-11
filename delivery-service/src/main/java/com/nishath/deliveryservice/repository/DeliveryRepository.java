package com.nishath.deliveryservice.repository;

import com.nishath.deliveryservice.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity,Integer> {
}
