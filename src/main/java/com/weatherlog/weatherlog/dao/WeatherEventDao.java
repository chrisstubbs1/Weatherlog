package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class WeatherEventDao {

    private WeatherEventList weatherEventList = new WeatherEventList();

    public List<WeatherEvent> getWeatherEvents(){
        return weatherEventList.getWeatherEvents();
    }

    public void addWeatherEvent(WeatherEvent weatherEventToAdd){
        weatherEventList.getWeatherEvents().add(weatherEventToAdd);
    }

    public WeatherEvent getWeatherEventById(UUID id){
        return weatherEventList.getWeatherEventById(id);
    }
}
