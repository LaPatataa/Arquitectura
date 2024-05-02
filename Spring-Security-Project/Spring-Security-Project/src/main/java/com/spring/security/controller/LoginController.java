package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "redirect:http://localhost:4200/login";
    }

    @GetMapping("/403")
    public String forbidden(){
        return "403";
    }
}
