package com.weatherlog.weatherlog.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/events")
public class EventsController {

    @GetMapping
    public String getUi(Model model){
        return "events";
    }
}
