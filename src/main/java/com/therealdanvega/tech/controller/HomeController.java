package com.therealdanvega.tech.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${techelevator.welcome-msg}")
    private String welcomeMsg;

    @RequestMapping("/")
    public String home() {
        return welcomeMsg;
    }
}
