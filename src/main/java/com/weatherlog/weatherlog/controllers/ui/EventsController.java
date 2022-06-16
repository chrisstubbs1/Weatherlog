package com.weatherlog.weatherlog.controllers.ui;

import com.weatherlog.weatherlog.services.WeatherEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/events")
public class EventsController {

    @Autowired
    WeatherEventService weatherEventService;

    @GetMapping
    public String getUi(Model model){
        model.addAttribute("weatherEvents", weatherEventService.getAllWeatherEvents());
        return "events";
    }

}
