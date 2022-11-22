package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RoleServiceClass implements RoleServiceInterface {
    @Autowired
    RoleRepository roleRepository;
    @PostConstruct
    public void init(){

    }
    @Override
    public void addRole(Role role){ roleRepository.save(role); }

    @Override
    public Role findRoleById(Long id){
        return roleRepository.getById(id);
    }

    @Override
    public void deleteRole(Role role){
        roleRepository.delete(role);
    }

    @Override
    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
}
