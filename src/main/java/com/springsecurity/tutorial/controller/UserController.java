package com.springsecurity.tutorial.controller;

import com.springsecurity.tutorial.model.User;
import com.springsecurity.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/join")
    public String joinForm() {
        return "user/join";
    }

    @PostMapping("/auth/join")
    public String joinProc(User user) {
        userService.회원가입(user);
        return "redirect:/";
    }

    @GetMapping("/auth/login")
    public String loginForm() {
        return "user/login";
    }
}
