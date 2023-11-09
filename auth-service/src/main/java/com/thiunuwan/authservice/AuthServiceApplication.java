package com.thiunuwan.authservice;

import com.thiunuwan.authservice.entity.Role;
import com.thiunuwan.authservice.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository) {
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

			roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			roleRepository.save(new Role("INVENTORY_KEEPER"));
			roleRepository.save(new Role("DElVERY_PERSON"));


			Set<Role> authorities = new HashSet<>();
			authorities.add(roleRepository.findByAuthority("ADMIN").get());
			authorities.add(roleRepository.findByAuthority("USER").get());
			authorities.add(roleRepository.findByAuthority("INVENTORY_KEEPER").get());
			authorities.add(roleRepository.findByAuthority("DELIVERY_PERSON").get());
//			ApplicationUser admin = new ApplicationUser(null,"thiunuwan", passwordEncoder.encode("rtv"),authorities);
//			userRepository.save(admin);

		};


	}

}