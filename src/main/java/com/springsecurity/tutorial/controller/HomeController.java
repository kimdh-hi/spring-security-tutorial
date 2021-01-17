package com.springsecurity.tutorial.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
//        if(authentication.isAuthenticated()) {
//            System.out.println("HomeController.home");
//        }
        return "index";
    }
}
