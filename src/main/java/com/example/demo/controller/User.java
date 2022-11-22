package com.example.demo.controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(length = 255)
    private String first_name;
    @Column(length = 255)
    private String last_name;
    @Column(length = 255, unique = true)
    private String login;
    @Column(length = 255)
    private String password;
    @Transient
    private  String match_password;

    public String getMatch_password() {
        return match_password;
    }

    public void setMatch_password(String match_password) {
        this.match_password = match_password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user__id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role__id", referencedColumnName = "id"
            )
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String first_name, String last_name, String login, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
    }
    public User(String first_name, String last_name, String login, String password) {
        Random random = new Random();
        this.id = random.nextLong();
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void addRole(Role role){ this.roles.add(role);}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
