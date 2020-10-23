package com.surittec.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRest {

    @GetMapping("/users")
    public List<User> getAllUsers();

    @GetMapping("/me")
    public User getUserAuthenticated();

}
