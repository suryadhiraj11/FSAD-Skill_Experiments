package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if users already exist
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");
            userRepository.save(admin);
            System.out.println("Admin user created successfully!");
        }

        if (userRepository.findByUsername("employee") == null) {
            User employee = new User();
            employee.setUsername("employee");
            employee.setPassword("emp123");
            employee.setRole("EMPLOYEE");
            userRepository.save(employee);
            System.out.println("Employee user created successfully!");
        }
    }
}
