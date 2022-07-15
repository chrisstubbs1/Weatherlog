package com.weatherlog.weatherlog.controllers.ui;

import com.weatherlog.weatherlog.weatherevent.services.WeatherEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/feedfrag")
public class FeedFragmentController {

    @Autowired
    WeatherEventService weatherEventService;

    @GetMapping
    public String getFeedFrag(Model model) {
        model.addAttribute("weatherevents", weatherEventService.getAllWeatherEvents());
        return "frags/feed::feed";
    }
}
