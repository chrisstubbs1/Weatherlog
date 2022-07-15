package com.weatherlog.weatherlog.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/createfrag")
public class CreateFragmentController {

    @GetMapping
    public String getCreateFrag() {
        return "frags/createfrag :: create";
    }
}
