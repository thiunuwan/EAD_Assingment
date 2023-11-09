package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.ItemRequestDTO;
import com.example.inventoryservice.dto.ItemResponseDTO;
import com.example.inventoryservice.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController()
@RequestMapping("/api/v1/inventory")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemServiceImpl;
    @PostMapping("/add-item")
    public ResponseEntity<String> addItem(@RequestBody ItemRequestDTO itemRequestDTO){
        String result= itemServiceImpl.addNewItem(itemRequestDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-all-items")
    public ResponseEntity<Page<ItemResponseDTO>> getAllItems(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size
    ) {

        ResponseEntity<Page<ItemResponseDTO>> responseEntity = null;

        Page<ItemResponseDTO> pageDTOs = itemServiceImpl.getAllItems(page, size);
        return responseEntity.ok(pageDTOs);
    }

    @GetMapping("/get-item/{id}")
    public ResponseEntity<ItemResponseDTO> getItemById(@PathVariable(name = "id") int id){
        ItemResponseDTO result= itemServiceImpl.getItemById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update-item/{id}")
    public ResponseEntity<String> updateItem(@RequestBody ItemRequestDTO itemRequestDTO, @PathVariable(name = "id") int id){
        String result= itemServiceImpl.updateItem(itemRequestDTO,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("delete-product/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable(name = "id") int id){
        String result= itemServiceImpl.deleteItem(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update-item/stock/{id}/{quantity}")
    public ResponseEntity<String> updateItemQuantity(@PathVariable(name = "id") int id,@PathVariable(name = "quantity") int quantity){
        String result= itemServiceImpl.updateItemQuantity(id,quantity);
        return ResponseEntity.ok(result);
    }



}
