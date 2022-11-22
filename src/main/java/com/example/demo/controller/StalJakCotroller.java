package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class StalJakCotroller {

    @Autowired
    RecordServiceInterface rekordService;
    @Autowired
    UserRepository userService;

    @Autowired
    RoleServiceInterface roleService;

    @GetMapping("/stal_jak")
    public String stal(Model model){
        List<Record> recordList = rekordService.findAllRecords();
        model.addAttribute("records", recordList);
        return "stal_jak";
    }
    @GetMapping("/panel")
    public String panel(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByLogin(auth.getName());
        if (currentUser.getRoles().contains(roleService.findRoleById(1L))){
            model.addAttribute("isUser",true);
        }

        if (currentUser.getRoles().contains(roleService.findRoleById(2L))){
            model.addAttribute("isAdmin",true);
        }

        return "panel";
    }
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/users_list")
    public String users_list(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByLogin(auth.getName());
        //if (currentUser.getRoles().contains(roleService.findRoleById(2L))){
            model.addAttribute("isAdmin",true);
            List<User> userList = userService.findAll();
            model.addAttribute("users",userList);
            System.out.println("THIS IS ADMIN");
            return "users_list";
        //}
        //return "redirect:/";
    }
    @GetMapping("/add_record")
    public String addRecord(Model model){
        Record record = new Record();
        model.addAttribute("rekord", record);
        return "addRecord";
    }
    @PostMapping(path="/add_record_New", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registerOK(Model model, Record record){
        Random random = new Random();

        System.out.println(record);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByLogin(auth.getName());


        rekordService.addRecord(record);

        return "redirect:/stal_jak";
    }

    @RequestMapping(value = "/record/view/{id}")
    public String getRecordView(@PathVariable("id") String id, Model model){
        System.out.println(id);
        Record record = rekordService.findRecordById(Long.parseLong(id));
        model.addAttribute("record", record);
        return "recordView";
    }
    @RequestMapping(value = "/record/edit/{id}")
    public String getRecordEdit(@PathVariable String id, Model model){
        Record record = rekordService.findRecordById(Long.parseLong(id));
        model.addAttribute("record", record);
        return "recordEdit";
    }

    @PostMapping("/record/edit/save")
        public String saveRecord(Record record){
            rekordService.addRecord(record);
            return "redirect:recordEdit?success";
        }



}
