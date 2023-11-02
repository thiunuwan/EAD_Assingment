package com.example.inventoryservice.service;


import com.example.inventoryservice.dto.ItemRequestDTO;
import com.example.inventoryservice.dto.ItemResponseDTO;
import com.example.inventoryservice.entity.Category;
import com.example.inventoryservice.entity.InventoryItem;
import com.example.inventoryservice.repository.CategoryRepository;
import com.example.inventoryservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    public String addNewItem(ItemRequestDTO itemRequestDTO) {

        Category category=categoryRepository.findById(itemRequestDTO.getCategory().getCategoryId()).orElse(null);

        InventoryItem newInventoryItem = InventoryItem.builder()
                .itemName(itemRequestDTO.getItemName())
                .category(category)
                .description(itemRequestDTO.getDescription())
                .unitPrice(itemRequestDTO.getUnitPrice())
                .imageURL(itemRequestDTO.getImageURL())
                .availableQuantity(itemRequestDTO.getAvailableQuantity())
                .build();
        itemRepository.save(newInventoryItem);
        return  "Product is successfully added to the inventory";
    }

    public Page<ItemResponseDTO> getAllItems(Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<InventoryItem> pageEntities = itemRepository.findAll(pageable);

        List<InventoryItem> entityList = pageEntities.getContent();
        List<ItemResponseDTO> dtoList = new ArrayList<>();

        entityList.forEach(entity -> dtoList.add(convertItemEntityToItemResponse(entity)));

        return new PageImpl<>(dtoList, pageable, pageEntities.getTotalElements());
    }

    public ItemResponseDTO convertItemEntityToItemResponse(InventoryItem entity) {
        ItemResponseDTO itemResponseDTO = ItemResponseDTO.builder()
                                                                .itemName(entity.getItemName())
                                                                .category(entity.getCategory())
                                                                .availableQuantity(entity.getAvailableQuantity())
                                                                .unitPrice(entity.getUnitPrice())
                                                                .itemId(entity.getItemId())
                                                                .description(entity.getDescription())
                                                                .imageURL(entity.getImageURL())
                                                                .build();
        return itemResponseDTO;
    }

    public ItemResponseDTO getItemById(int id) {
        InventoryItem inventoryItemEntity = itemRepository.findById(id).orElse(null);
        ItemResponseDTO itemResponseDTO = ItemResponseDTO.builder()
                .itemName(inventoryItemEntity.getItemName())
                .category(inventoryItemEntity.getCategory())
                .availableQuantity(inventoryItemEntity.getAvailableQuantity())
                .unitPrice(inventoryItemEntity.getUnitPrice())
                .description(inventoryItemEntity.getDescription())
                .imageURL(inventoryItemEntity.getImageURL())
                .itemId(inventoryItemEntity.getItemId())
                .build();
        return itemResponseDTO;
    }

    public String updateItem(ItemRequestDTO itemRequestDTO, int id) {
        InventoryItem inventoryItemEntity = itemRepository.findById(id).orElse(null);
        inventoryItemEntity.setItemName(itemRequestDTO.getItemName());
        inventoryItemEntity.setCategory(itemRequestDTO.getCategory());
        inventoryItemEntity.setUnitPrice(itemRequestDTO.getUnitPrice());
        inventoryItemEntity.setDescription(itemRequestDTO.getDescription());
        inventoryItemEntity.setAvailableQuantity(itemRequestDTO.getAvailableQuantity());
        inventoryItemEntity.setImageURL(itemRequestDTO.getImageURL());
        itemRepository.save(inventoryItemEntity);
        return "Item is successfully updated";
    }

    public String deleteItem(int id) {
        itemRepository.deleteById(id);
        return "Item is successfully deleted";
    }
}
