package com.example.inventoryservice;

import com.example.inventoryservice.entity.Category;
import com.example.inventoryservice.entity.InventoryItem;
import com.example.inventoryservice.entity.Unit;
import com.example.inventoryservice.repository.CategoryRepository;
import com.example.inventoryservice.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	//add defaults items to inventory_db
	@Bean
	CommandLineRunner run(ItemRepository itemRepository, CategoryRepository categoryRepository){
		return args ->{

			if(itemRepository.existsById(1))return;

			Category category1=new Category();
			category1.setName("snacks");
			category1.setDescription("snacks desc");
			categoryRepository.save(category1);

			itemRepository.save(new InventoryItem(1,  "tikiri mari","Biscuits", "https://example.com/oreo.jpg", 60, 7.4, Unit.EACH,category1));
			itemRepository.save(new InventoryItem(5, "cheese-bits","Biscuits", "https://example.com/shortbread.jpg", 35, 3.49,Unit.EACH,category1));
			itemRepository.save(new InventoryItem(10, "cream cracker","Biscuits",  "https://example.com/ginger.jpg", 45, 2.99,Unit.EACH,category1));


		};

	}


}


