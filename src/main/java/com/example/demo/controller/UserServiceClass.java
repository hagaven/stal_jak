package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceClass implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @PostConstruct
    public void init(){

    }

    @Override
    public void addUser(User user) {

            userRepository.save(user);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long id){
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(s);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),toRoleAuth(user.getRoles()) );
    }

    private Collection<? extends GrantedAuthority> toRoleAuth(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
