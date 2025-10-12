package com.college.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==========================================");
        System.out.println("College Management System Started!");
        System.out.println("Health endpoint: /api/v1/health");
        System.out.println("Test endpoint: /api/v1/test");
        System.out.println("==========================================");
    }
}
