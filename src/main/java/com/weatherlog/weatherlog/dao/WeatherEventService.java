package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherEventService {

    @Autowired
    WeatherEventsRepository weatherEventsRepository;

    public List<WeatherEvent> getAllWeatherEvents(){
        List<WeatherEvent> weatherEvents = new ArrayList<>();
        weatherEventsRepository.findAll().forEach(weatherEvents::add);

        return weatherEvents;
    }

    public void addWeatherEvent(WeatherEvent weatherEventToAdd){
        weatherEventsRepository.save(weatherEventToAdd);
    }

    public WeatherEvent getWeatherEventById(Long idOfEvent){
        return weatherEventsRepository.findById(idOfEvent).get();
    }

    public void removeWeatherEventById(Long id){
        weatherEventsRepository.deleteById(id);
    }
}
