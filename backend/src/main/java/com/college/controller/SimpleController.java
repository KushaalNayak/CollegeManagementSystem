package com.college.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class SimpleController {

    @GetMapping("/")
    public String home() {
        return "College Management System API is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/v1/health")
    public String apiHealth() {
        return "OK";
    }

    @GetMapping("/api/v1/test")
    public String test() {
        return "Backend is working!";
    }
}
