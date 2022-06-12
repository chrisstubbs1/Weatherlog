package com.weatherlog.weatherlog.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping(value = "/signup")
    public String getSignUpUI(){
        return "signup";
    }
}
