package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.CategoryRequestDTO;
import com.example.inventoryservice.dto.CategoryResponseDTO;
import com.example.inventoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/inventory/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add-category")
    public ResponseEntity<String> addItem(@RequestBody CategoryRequestDTO categoryRequestDTO){
        String result= categoryService.addNewCategory(categoryRequestDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("delete-category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") int id){
        String result= categoryService.deleteCategory(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("get-categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<CategoryResponseDTO> categoryResponseDTOList=categoryService.getAllCategories();
        return ResponseEntity.ok(categoryResponseDTOList);
    }


}
