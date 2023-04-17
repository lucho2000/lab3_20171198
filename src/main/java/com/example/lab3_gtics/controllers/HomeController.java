package com.example.lab3_gtics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HomeController {
    @GetMapping("/")
    public String index(){
        return "p";
    }

}
