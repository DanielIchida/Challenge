package com.mercadolibre.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(
		basePackages = "com.mercadolibre.challenge.infraestructure.database.repositories"
)
@Configuration
@EnableJpaAuditing
@SpringBootApplication
@EntityScan(
		basePackages = "com.mercadolibre.challenge.infraestructure.database.entities"
)
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
