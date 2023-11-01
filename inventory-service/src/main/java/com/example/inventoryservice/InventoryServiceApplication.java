package com.example.inventoryservice;

import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	//add defaults products to inventory_db
	@Bean
	CommandLineRunner run(ProductRepository productRepository){
		return args ->{

			if(productRepository.existsById(1))return;

			productRepository.save(new Product(1,  "Biscuits", "Classic Oreo sandwich cookies", "https://example.com/oreo.jpg", 60, 7.4));
			productRepository.save(new Product(5, "Biscuits", "Buttery shortbread cookies", "https://example.com/shortbread.jpg", 35, 3.49));
			productRepository.save(new Product(10, "Biscuits", "Spicy ginger snap cookies", "https://example.com/ginger.jpg", 45, 2.99));


		};

	}


}


