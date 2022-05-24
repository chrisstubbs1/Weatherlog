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
			// save a few events
			weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 77, "Stormy night in Macon"));
			weatherEventsRepository.save(new WeatherEvent("Flagstaff, Az", 86, "Dry and humid day here!"));
			weatherEventsRepository.save(new WeatherEvent("Atlanta, Ga", 73, "Perfect afternoon." +
					" Not a cloud in the sky"));
			weatherEventsRepository.save(new WeatherEvent("Orlando, Fl", 72, "Overcast day"));
			weatherEventsRepository.save(new WeatherEvent("Birmingham, Al", 81, "Humid day. Rained in the morning."));
			weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon"));

		};
	}
}
