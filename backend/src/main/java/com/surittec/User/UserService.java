package com.surittec.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User getUserAuthenticated();

    public List<User> getAllUsers();

}
