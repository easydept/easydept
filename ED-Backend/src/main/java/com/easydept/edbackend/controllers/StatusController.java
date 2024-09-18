package com.easydept.edbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/controllers/status")
    public String status() {
        return "EasyDept -..? API, Spring Boot is running!";
    }
}