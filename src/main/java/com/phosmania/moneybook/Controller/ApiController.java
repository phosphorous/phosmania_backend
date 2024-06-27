package com.phosmania.moneybook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ApiController {

    @GetMapping("/api/welcome")
    public String welcome(Principal principal) {
        return "Welcome, " + principal.getName();
    }

    @GetMapping("/api/login")
    public String login() {
        return "Please login";
    }
}
