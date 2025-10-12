package com.college.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class SimpleAuthController {

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequest request) {
        // Simple hardcoded login for testing
        if ("admin@college.com".equals(request.getEmail()) && "admin123".equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("fake-jwt-token", 1L, "admin@college.com", "ADMIN"));
        }
        if ("student@college.com".equals(request.getEmail()) && "student123".equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("fake-jwt-token", 2L, "student@college.com", "STUDENT"));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok("User registered successfully");
    }

    // Simple DTOs
    public static class LoginRequest {
        public String email;
        public String password;
        
        public String getEmail() { return email; }
        public String getPassword() { return password; }
    }

    public static class SignupRequest {
        public String email;
        public String password;
        public String firstName;
        public String lastName;
    }

    public static class LoginResponse {
        public String accessToken;
        public Long id;
        public String email;
        public String role;

        public LoginResponse(String accessToken, Long id, String email, String role) {
            this.accessToken = accessToken;
            this.id = id;
            this.email = email;
            this.role = role;
        }
    }
}
