package com.example.demo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan("com.example.demo")
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/stal_jak").setViewName("stal_jak");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/panel").setViewName("panel");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/register/success").setViewName("registerSuccess");

    }

}
