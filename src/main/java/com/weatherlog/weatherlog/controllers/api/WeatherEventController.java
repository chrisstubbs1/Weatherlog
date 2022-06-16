package com.weatherlog.weatherlog.controllers.api;

import com.weatherlog.weatherlog.services.WeatherEventService;
import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/weatherevents")
@RestController
public class WeatherEventController {


    @Autowired
    private WeatherEventService weatherEventService;

    @GetMapping
    private List<WeatherEvent> getWeatherEvents(){
        return weatherEventService.getAllWeatherEvents();
    }

    @PostMapping
    private void addWeatherEvent(@RequestBody WeatherEvent weatherEventToAdd){
        weatherEventService.addWeatherEvent(weatherEventToAdd);
    }

    @GetMapping(path = "/{id}")
    private WeatherEvent getWeatherEventById(@PathVariable Long id){
        return weatherEventService.getWeatherEventById(id);
    }

    @DeleteMapping(path = "/{id}")
    private void deleteWeatherEventById(@PathVariable Long id){
        weatherEventService.removeWeatherEventById(id);
    }

}
