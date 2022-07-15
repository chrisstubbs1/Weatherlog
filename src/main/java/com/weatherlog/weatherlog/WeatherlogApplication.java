package com.weatherlog.weatherlog;

import com.weatherlog.weatherlog.user.dao.UserRepository;
import com.weatherlog.weatherlog.weatherevent.dao.WeatherEventsRepository;
import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class WeatherlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherlogApplication.class, args);
    }

    //seed some sample data for the database
    @Bean
    public CommandLineRunner demo(WeatherEventsRepository weatherEventsRepository, UserRepository userRepository, ApplicationContext applicationContext) {
        return (args) -> {
            // save a few events
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 77, "Stormy night in Macon", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Flagstaff, Az", 86, "Dry and humid day here!", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Atlanta, Ga", 73, "Perfect afternoon." +
                    " Not a cloud in the sky", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Orlando, Fl", 72, "Overcast day", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Birmingham, Al", 81, "Humid day. Rained in the morning.", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon", LocalDate.now(), 1L));
            weatherEventsRepository.save(new WeatherEvent("Macon, Ga", 49, "Stormy day in Macon", LocalDate.now(), 1L));

            //make some sample users
            userRepository.save(new User("Chris", "Stubbs", "chrisstubbs1",
                    "chris.stubbs@neenah.com", "password", "2011-01-09"));

        };
    }
}
