package com.weatherlog.weatherlog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String getUI(Model model){
        return "index";
    }

    @PostMapping(path = "/")
    public String onPost(String location, Double temperature, String comment ){
        return "index";
    }
}
