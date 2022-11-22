package com.example.demo;

import com.example.demo.controller.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@WebAppConfiguration
@ContextConfiguration(classes = DemoApplication.class)
@WebMvcTest(LoginController.class)
//@AutoConfigureMockMvc
public class RegisterTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private LoginController loginController;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private RecordRepository recordRepository;
    @MockBean
    private RoleRepository roleRepository;
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//    @BeforeEach
//    public void setup() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
//                .alwaysDo(print())
//                .build();
//    }

    @Test
    public void registerGetTest() throws Exception {
        this.mockMvc.perform(get("/register"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void registerPostTest() throws Exception {
        User user =new User();
//        user.setLogin("test");
//        user.setPassword("qwe");
//        user.setLast_name("TEST");
//        user.setFirst_name("TSET");
//        user.setMatch_password("qwe");
        MvcResult result = this.mockMvc.perform(get("/register")
                .flashAttr("login","test")
                .flashAttr("password","qwe")
                .flashAttr("last_name","TEST")
                .flashAttr("firs_name","TSET")
                .flashAttr("match_password","qwe")
                .flashAttr("user",user)
        ).andDo(print())
//                .andExpect(view().name("registerSuccess"))
//                .andExpect(model().attribute("login","test"))
//                .andExpect(model().attribute("password","qwe"))
//                .andExpect(model().attribute("last_name","TEST"))
//                .andExpect(model().attribute("first_name","TSET"))
//                .andExpect(model().attribute("match_password","qwe"))
//                .andExpect(model().attribute("user",user))
                .andReturn();

        System.out.println(result.getFlashMap().getTargetRequestParams());
        System.out.println(result.getFlashMap().getTargetRequestPath());
        mockMvc.perform(post("/register")
                        .param("login","test")
                        .param("password","qwe")
                        .param("last_name","TEST")
                        .param("firs_name","TSET")
                        .param("match_password","qwe")
                        .param("user",user.toString())
                ).andDo(print()).andReturn();
    }
}
