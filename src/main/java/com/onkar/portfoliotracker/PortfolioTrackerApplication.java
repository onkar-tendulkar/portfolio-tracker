package com.onkar.portfoliotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.onkar"})
@EntityScan("com.onkar.domain")
@EnableJpaRepositories("com.onkar.repository")
public class PortfolioTrackerApplication {



	public static void main(String[] args) {
		SpringApplication.run(PortfolioTrackerApplication.class, args);
	}

}
