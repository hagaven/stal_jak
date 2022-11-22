package com.example.demo.controller;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.math.BigInteger;
import java.util.List;

public interface UserServiceInterface extends UserDetailsService {
    public void addUser(User user);
    public User findUserById(Long id);
    public void deleteUser(User user);
    public List<User> findAllUsers();
    public void updateUser(User user);

}
