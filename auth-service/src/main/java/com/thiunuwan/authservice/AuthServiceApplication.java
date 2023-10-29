package com.thiunuwan.authservice;

import com.thiunuwan.authservice.entity.ApplicationUser;
import com.thiunuwan.authservice.entity.Role;
import com.thiunuwan.authservice.repository.RoleRepository;
import com.thiunuwan.authservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApplication.class, args);

	}


	//make sure there is an admin user by creating admin user in  here.
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
	return args ->{

		if(roleRepository.findByAuthority("ADMIN").isPresent())return;

		Role adminRole = roleRepository.save(new Role("ADMIN"))	;
		Role userRole  = roleRepository.save(new Role("USER"));
		Role inventoryKeeperRole  = roleRepository.save(new Role("INVENTORY_KEEPER"));
		Role deliveryPersonRole  = roleRepository.save(new Role("DElVERY_PERSON"));



		Set<Role> roles = new HashSet<>();
		roles.add(adminRole);
		roles.add(userRole);
		roles.add(inventoryKeeperRole);
		roles.add(deliveryPersonRole);
		ApplicationUser admin = new ApplicationUser(1,"admin", passwordEncoder.encode("admin123"),roles );
		userRepository.save(admin);

	};

	}

}
