package com.surittec.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    private UserService UserService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/me")
    public User getUserAuthenticated() {
        return UserService.getUserAuthenticated();
    }
}
