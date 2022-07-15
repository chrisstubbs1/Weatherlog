package com.weatherlog.weatherlog.security.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/security")
public class SecurityController {


    @GetMapping
    @ResponseBody
    public String currentUsername(Authentication authentication) {
        return authentication.name();
    }

}
