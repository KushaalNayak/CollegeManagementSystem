package com.college.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    
    @GetMapping("/")
    public String root() {
        return "College Management System API is running!";
    }
}
