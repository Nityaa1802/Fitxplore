package com.mycompany.crudapp.controller;

import com.mycompany.crudapp.model.User;
import com.mycompany.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> users=userService.listAll();
        model.addAttribute("listUsers",users);
        return "users";
    }
}
