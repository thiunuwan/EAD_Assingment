package com.example.inventoryservice.repository;

import com.example.inventoryservice.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<InventoryItem,Integer> {


}
