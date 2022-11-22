package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Random;


@Controller
public class LoginController {

    @Autowired
    UserServiceInterface userService;

    @Autowired
    RoleServiceInterface roleService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping(path="/register", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        public String registerOK(Model model, @ModelAttribute("user") User user){
        Random random = new Random();

        System.out.println(user);
        System.out.println(user.getMatch_password());
        System.out.println(user.getPassword());
        if(!user.getPassword().equals(user.getMatch_password())){
            model.addAttribute("passwordMismatch",true);
            return "register";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User newUser = new User(random.nextLong(),user.getFirst_name(),user.getLast_name(),user.getLogin(), encoder.encode(user.getPassword()));
        Long id = random.nextLong();
        Role r=roleService.findRoleById(1L);
        newUser.addRole(r);
        try{
            userService.addUser(newUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            model.addAttribute("alreadyExist",true);
            return "register";
        }

        System.out.println(newUser);
        System.out.println("success");

        return "redirect:/register/success";
    }


    @GetMapping("/register/success")
    public String getSuccess() {
        return "redirect:/login";
    }

    @GetMapping("/change_password")
    public String changePassword(){
        return "/changePassword";
    }

    @PostMapping(path = "/change_password",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String changedPassword(Model model,@RequestParam Map<String,String> credentials){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String oldPass=credentials.get("oldPassword");
        String newPass=credentials.get("newPassword");
        String match=credentials.get("matchNewPassword");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByLogin(auth.getName());

        if(!newPass.equals(match)){
            model.addAttribute("passwordMismatch",true);
            return "redirect:/change_password";
        }
        if(oldPass.equals(newPass)){
            model.addAttribute("samePassword",true);
            return "redirect:/change_password";
        }
        System.out.println(encoder.matches(oldPass,currentUser.getPassword()));
        if(!encoder.matches(oldPass,currentUser.getPassword())){
            model.addAttribute("passwordMismatch",true);
            return "redirect:/change_password";
        }
        User changed = new User(currentUser.getId(),currentUser.getFirst_name(),currentUser.getLast_name(),currentUser.getLogin(),encoder.encode(newPass));
        changed.setRoles(currentUser.getRoles());
        currentUser.setPassword(encoder.encode(newPass));
        try{
            userService.updateUser(currentUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }


}
