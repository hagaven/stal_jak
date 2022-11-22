package com.example.demo;

import com.example.demo.controller.MvcConfig;
import com.example.demo.controller.WebSecurityConfig;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class LoginTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void loginGetTest() throws Exception {
        ServletContext servletContext=webApplicationContext.getServletContext();
        Assert.assertNotNull(servletContext);
        MvcResult result=this.mockMvc.perform(get("/login")
                .requestAttr("login","asdf")
                .requestAttr("password","qwe"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void loginPostTest() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/login")
                .requestAttr("login","asdf")
                .requestAttr("password","qwe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
