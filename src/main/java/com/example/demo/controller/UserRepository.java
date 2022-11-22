package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
