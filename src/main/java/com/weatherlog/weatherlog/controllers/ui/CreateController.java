package com.weatherlog.weatherlog.controllers.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class CreateController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String getUI(Model model){
        return "create";
    }

}
