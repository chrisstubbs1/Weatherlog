package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.WeatherEvent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class WeatherEventList {

    private List<WeatherEvent> weatherEvents;

    public WeatherEventList() {
        this.weatherEvents = new ArrayList<>();
        weatherEvents.add(new WeatherEvent("Atlanta, Georgia", 72.4, new Date(), "none"));
        weatherEvents.add(new WeatherEvent("Birmingham, Alabama", 69.4, new Date(), "Nice mild day"));

    }

    public void addWeatherEvent(WeatherEvent weatherEventToAdd){
        this.weatherEvents.add(weatherEventToAdd);
    }

    public WeatherEvent getWeatherEventById(UUID uuid){
        for (WeatherEvent event : weatherEvents){
            if (event.getId().equals(uuid))
                return event;
        }

        return null;
    }
}
