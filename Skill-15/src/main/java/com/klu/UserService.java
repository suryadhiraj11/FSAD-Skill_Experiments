package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User save(User user) {
        return repo.save(user);
    }
}