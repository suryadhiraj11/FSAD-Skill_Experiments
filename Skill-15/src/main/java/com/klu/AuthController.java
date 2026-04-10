package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER → Create new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        try {
            User existingUser = service.findByUsername(user.getUsername());
            if (existingUser != null) {
                response.put("error", "Username already exists");
                return ResponseEntity.badRequest().body(response);
            }
            
            User savedUser = service.save(user);
            response.put("message", "User registered successfully");
            response.put("username", savedUser.getUsername());
            response.put("role", savedUser.getRole());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Registration failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    // LOGIN → Generate JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        try {
            User dbUser = service.findByUsername(user.getUsername());

            if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUsername());
                response.put("token", token);
                response.put("role", dbUser.getRole());
                response.put("username", dbUser.getUsername());
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Invalid credentials");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("error", "Login failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    // ADMIN APIs
    @PostMapping("/admin/add")
    public ResponseEntity<?> add() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Admin can add");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> delete() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Admin can delete");
        return ResponseEntity.ok(response);
    }

    // EMPLOYEE API
    @GetMapping("/employee/profile")
    public ResponseEntity<?> profile() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee profile");
        return ResponseEntity.ok(response);
    }
}