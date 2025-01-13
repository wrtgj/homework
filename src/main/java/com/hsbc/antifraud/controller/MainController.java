package com.hsbc.antifraud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@ComponentScan("com.example.controller")
@RequestMapping("/main")
public class MainController {
    @GetMapping("/top")
    public String login() {
        return "login";
    }
}

