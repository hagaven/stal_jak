package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

public interface RoleServiceInterface {
    public void addRole(Role role);
    public Role findRoleById(Long id);
    public void deleteRole(Role role);
    public List<Role> findAllRoles();
}
