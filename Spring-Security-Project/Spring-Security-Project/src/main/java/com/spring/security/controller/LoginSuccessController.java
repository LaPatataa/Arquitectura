package com.spring.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSuccessController {

    @GetMapping("/loginSuccess")
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response) {
        // Lógica adicional si es necesario
        return "redirect:http://localhost:4200/calendario";
    }
}
