package com.weatherlog.weatherlog.controllers;

import com.weatherlog.weatherlog.dao.WeatherEventDao;
import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = "/api/weatherevents")
@RestController
public class WeatherEventController {

    @Autowired
    private WeatherEventDao weatherEventDao;

    @GetMapping
    private List<WeatherEvent> getWeatherEvents(){
        return weatherEventDao.getWeatherEvents();
    }

    @GetMapping(path = "/{id}")
    private WeatherEvent getWeatherEventById(@PathVariable UUID id){
        return weatherEventDao.getWeatherEventById(id);
    }

}
