package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        System.out.println("Registering user: " + user.getUsername() + ", password: " + user.getPassword());
        User saved = repo.save(user);
        System.out.println("User saved with id: " + saved.getId());
        return saved;
    }

    public User login(User user) {
        User existing = repo.findByUsername(user.getUsername());
        System.out.println("Login attempt for username: " + user.getUsername());
        System.out.println("Provided password: " + user.getPassword());

        if (existing != null) {
            System.out.println("Found user: " + existing.getUsername() + ", stored password: " + existing.getPassword());
            if (existing.getPassword().equals(user.getPassword())) {
                System.out.println("Password match, login successful");
                return existing;
            } else {
                System.out.println("Password does not match");
            }
        } else {
            System.out.println("User not found");
        }

        return null;
    }

    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}