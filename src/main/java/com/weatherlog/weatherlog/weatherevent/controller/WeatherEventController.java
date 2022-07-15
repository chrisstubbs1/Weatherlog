package com.weatherlog.weatherlog.weatherevent.controller;

import com.weatherlog.weatherlog.validation.ValidationResult;
import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;
import com.weatherlog.weatherlog.weatherevent.services.WeatherEventService;
import com.weatherlog.weatherlog.weatherevent.validation.WeatherEventValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping(path = "/api/weatherevents")
@RestController
public class WeatherEventController {

    private Logger logger = LoggerFactory.getLogger(WeatherEventController.class);

    @Autowired
    private WeatherEventService weatherEventService;
    @Autowired
    public WeatherEventValidationService weatherEventValidationService;

    @GetMapping
    public List<WeatherEvent> getWeatherEvents(){
        return weatherEventService.getAllWeatherEvents();
    }

    @PostMapping
    public ResponseEntity<String> addWeatherEvent(RequestEntity<WeatherEvent> entity){

        WeatherEvent weatherEvent = entity.getBody();
//        weatherEvent.setCreatorId();
        ValidationResult result = weatherEventValidationService.validateAll(weatherEvent);

        if (result.isValid()){
            return postWeatherEvent(weatherEvent);
        }

        logger.info("Could not add weather event. Error: {}", result.getReason().get());
        return new ResponseEntity<String>("Could not process request.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{id}")
    public WeatherEvent getWeatherEventById(@PathVariable Long id){
        return weatherEventService.getWeatherEventById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteWeatherEventById(@PathVariable Long id){
        weatherEventService.removeWeatherEventById(id);
    }

    private ResponseEntity<String> postWeatherEvent(WeatherEvent weatherEvent) {
        weatherEventService.addWeatherEvent(weatherEvent);
        logger.info("Weather Event {} Added.", weatherEvent.getId());

        return ResponseEntity
                .created(URI.create(String.format("/api/users/%d", weatherEvent.getId())))
                .build();
    }
}
