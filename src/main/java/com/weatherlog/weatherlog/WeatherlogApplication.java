package com.weatherlog.weatherlog;

import com.weatherlog.weatherlog.dao.WeatherEventsRepository;
import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class WeatherlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherlogApplication.class, args);
	}

	//seed some sample data for the database
	@Bean
	public CommandLineRunner demo(WeatherEventsRepository weatherEventsRepository) {
		return (args) -> {
			// save a few customers
			weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 22, "Stormy night in Macon"));
		};
	}
}
