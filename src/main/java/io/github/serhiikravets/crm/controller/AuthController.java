package io.github.serhiikravets.crm.controller;

import io.github.serhiikravets.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    @RequiredArgsConstructor
    public class AuthController {

        private final UserService userService;

        @GetMapping("/login")
        public String login() {
            return "auth/login";
        }

        @GetMapping("/register")
        public String registerForm() {
            return "auth/register";
        }

        @PostMapping("/register")
        public String register(
                @RequestParam String email,
                @RequestParam String password
        ) {
            userService.register(email, password);
            return "redirect:/login";
        }
    }

