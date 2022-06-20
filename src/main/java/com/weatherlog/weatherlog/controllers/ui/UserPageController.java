package com.weatherlog.weatherlog.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/userpage")
public class UserPageController {

    @GetMapping
    public String getUI() {
        return "userpage";
    }
}
