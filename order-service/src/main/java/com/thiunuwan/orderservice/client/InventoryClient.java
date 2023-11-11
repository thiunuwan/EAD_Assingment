package com.thiunuwan.orderservice.client;

import com.thiunuwan.orderservice.dto.DeductItemsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service",url = "http://localhost:8092/api/v1/inventory")
public interface InventoryClient {

    @PutMapping("/update-item/stock/by-deduct-item-list")
    ResponseEntity<String> updateItemQuantitiesByDeductItemList(@RequestBody List<DeductItemsResponseDTO> deductItemsResponseDTO);

}
