package com.springsecurity.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping({"", "/"})
    public String home() {

        return "index";
    }
}

//    @Autowired
//    private PrincipalDetails principal;

// System.out.println("로그인 정보(Username) = " + principalDetails.getUsername());