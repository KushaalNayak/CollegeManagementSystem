package com.college.config;

import com.college.entity.User;
import com.college.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if not exists
        if (!userRepository.existsByEmail("admin@college.com")) {
            User admin = new User(
                "admin@college.com",
                passwordEncoder.encode("admin123"),
                "Admin",
                "User",
                User.Role.ADMIN
            );
            userRepository.save(admin);
            logger.info("Default admin user created: admin@college.com / admin123");
        }

        // Create default student user if not exists
        if (!userRepository.existsByEmail("student@college.com")) {
            User student = new User(
                "student@college.com",
                passwordEncoder.encode("student123"),
                "John",
                "Doe",
                User.Role.STUDENT
            );
            userRepository.save(student);
            logger.info("Default student user created: student@college.com / student123");
        }

        // Create default faculty user if not exists
        if (!userRepository.existsByEmail("faculty@college.com")) {
            User faculty = new User(
                "faculty@college.com",
                passwordEncoder.encode("faculty123"),
                "Jane",
                "Smith",
                User.Role.FACULTY
            );
            userRepository.save(faculty);
            logger.info("Default faculty user created: faculty@college.com / faculty123");
        }

        // Create default HOD user if not exists
        if (!userRepository.existsByEmail("hod@college.com")) {
            User hod = new User(
                "hod@college.com",
                passwordEncoder.encode("hod123"),
                "Dr. Michael",
                "Johnson",
                User.Role.HOD
            );
            userRepository.save(hod);
            logger.info("Default HOD user created: hod@college.com / hod123");
        }
    }
}
