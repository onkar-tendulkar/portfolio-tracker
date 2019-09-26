package com.onkar.portfoliotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com.onkar"})
@EntityScan("com.onkar.domain")
@EnableJpaRepositories("com.onkar.repository")
@EnableScheduling()
public class PortfolioTrackerApplication {



	public static void main(String[] args) {
		SpringApplication.run(PortfolioTrackerApplication.class, args);
	}

}
