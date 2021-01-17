package com.springsecurity.tutorial.controller;

import com.springsecurity.tutorial.config.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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